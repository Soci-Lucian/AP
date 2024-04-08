package org.example;



public class Main {
    public static void main(String[] args) {

        RepositoryManager repositoryManager = new RepositoryManager("C:\\Users\\Lucian\\Desktop\\AC - JAVA\\AP\\Lab5");
        Shell shell = new Shell(repositoryManager);
        shell.run();
    }
}