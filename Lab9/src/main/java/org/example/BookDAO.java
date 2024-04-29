package org.example;

import org.example.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDAO {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");

    public void addBook(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        entityManager.close();
    }

    public List<Book> getAllBooks() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();
        entityManager.close();
        return books;
    }
}
