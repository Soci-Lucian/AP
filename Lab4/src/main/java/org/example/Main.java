package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Gabriel", "Enirico", "Robert", "Albert", "Lucian", "Marcelin", "Marius", "Andrei", "Gabriela", "Roberta");
        List<Integer> ages = Arrays.asList(26, 31, 23, 41, 36, 29, 34, 46, 19, 29);
        List<String> destinations = Arrays.asList("Iasi", "Bucuresti", "Bacau", "Brasov", "Suceava");


        List<Person> persons = generatePersons(names, ages, destinations); // Generate a random group of persons

        // Put drivers in a LinkedList and sort
        List<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person).sorted(Comparator.comparingInt(driver -> driver.age)).collect(Collectors.toCollection(LinkedList::new));

        // Create a custom comparator for sorting passengers by name
        Comparator<Passenger> passengerComparator = Comparator.comparing(passenger -> passenger.name);

        // Put passengers in a TreeSet and sort them using the custom comparator
        Set<Passenger> sortedPassengers = persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toCollection(() -> new TreeSet<>(passengerComparator)));

        // Print drivers sorted by age
        System.out.println("Drivers (sorted by age):");
        for (Driver driver : drivers) {
            System.out.println(driver.name + " - Age: " + driver.age + " - Destination: " + driver.destination);
        }

        // Print passengers sorted by name
        System.out.println("\nPassengers (sorted by name):");
        for (Passenger passenger : sortedPassengers) {
            System.out.println(passenger.name + " - Age: " + passenger.age + " - Destination: " + passenger.destination);
        }
    }

    // Method to generate a random group of persons with randomly assigned destinations
    private static List<Person> generatePersons(List<String> names, List<Integer> ages, List<String> destinations) {
        if (names.size() != ages.size() || destinations.isEmpty()) {
            throw new IllegalArgumentException("Invalid input lists");
        }

        List<Person> persons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int age = ages.get(i);
            String destination = destinations.get(random.nextInt(destinations.size()));

            boolean isDriver = random.nextBoolean();

            if (isDriver) {
                persons.add(new Driver(name, destination, age));
            } else {
                persons.add(new Passenger(name, destination, age));
            }
        }

        return persons;
    }
}
