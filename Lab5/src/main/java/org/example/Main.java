package org.example;

public class Main {
    public static void main(String[] args) throws RepositoryException {
        DocumentRepository repository = new DocumentRepository("C:\\Users\\Lucian\\Desktop\\AC - JAVA\\AP\\Lab5Folders");
        repository.displayRepositoryContent();
    }
}