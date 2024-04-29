package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Test Database Connection
            Connection connection = ConnectionPool.getInstance().getConnection();
            if (connection != null) {
                System.out.println("Connected to the database.");
            } else {
                System.out.println("Failed to connect to the database.");
                return;
            }

            // Test BookDAO
            BookDAO bookDAO = new BookDAO();

            // Add a book
            Book bookToAdd = new Book("Sample Book", Arrays.asList("Author1", "Author2"), "English", LocalDate.now(), 200);
            bookDAO.addBook(bookToAdd);

            // Get all books
            System.out.println("List of Books:");
            List<Book> books = bookDAO.getAllBooks();
            for (Book book : books) {
                System.out.println(book.getTitle() + " - " + book.getLanguage());
            }

            // Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
