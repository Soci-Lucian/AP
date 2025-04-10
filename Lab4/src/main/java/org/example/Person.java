package org.example;

public class Person {
    public String name;
    public String destination;
    public int age;

    public Person(String name, String destination, int age) {
        this.name = name;
        this.destination = destination;
        this.age = age;
    }

    public String getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
