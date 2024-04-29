package org.example;

import org.example.Book;
import org.example.BookDAO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
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
                System.out.println("Authors: " + book.getAuthors());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
