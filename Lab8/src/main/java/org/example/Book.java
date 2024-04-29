package org.example;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private String title;
    private List<String> authors; // List of author names
    private String language;
    private LocalDate publicationDate;
    private int numPages;

    public Book(String title, List<String> authors, String language, LocalDate publicationDate, int numPages) {
        this.title = title;
        this.authors = authors;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numPages = numPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}
