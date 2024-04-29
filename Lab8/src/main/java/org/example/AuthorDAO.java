package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private final Connection connection;

    public AuthorDAO() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    public void addAuthor(String name) throws SQLException {
        String sql = "INSERT INTO Author (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
    }

    public List<String> getAllAuthors() throws SQLException {
        List<String> authors = new ArrayList<>();
        String sql = "SELECT name FROM Author";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                authors.add(resultSet.getString("name"));
            }
        }
        return authors;
    }
}
