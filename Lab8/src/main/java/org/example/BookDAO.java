package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final ConnectionPool connectionPool;

    public BookDAO() {
        connectionPool = ConnectionPool.getInstance();
    }

    public void addBook(Book book) throws SQLException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Book (title, language, publication_date, num_pages) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getLanguage());
            statement.setDate(3, Date.valueOf(book.getPublicationDate()));
            statement.setInt(4, book.getNumPages());
            statement.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Book")) {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String language = resultSet.getString("language");
                LocalDate publicationDate = resultSet.getDate("publication_date").toLocalDate();
                int numberOfPages = resultSet.getInt("num_pages");
                Book book = new Book(title, null, language, publicationDate, numberOfPages);
                books.add(book);
            }
        }
        return books;
    }
}
