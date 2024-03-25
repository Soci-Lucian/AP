package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        List<Person> persons = generatePersons(faker);

        // Put drivers in a LinkedList and sort
        List<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .sorted(Comparator.comparingInt(driver -> driver.age))
                .collect(Collectors.toCollection(LinkedList::new));

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
            System.out.println(driver.name + " - Age: " + driver.age + " - Destination: " + driver.getDestinations());
        }

        // Print passengers sorted by name
        System.out.println("\nPassengers (sorted by name):");
        for (Passenger passenger : sortedPassengers) {
            System.out.println(passenger.name + " - Age: " + passenger.age + " - Destination: " + passenger.destination);
        }

        CarPoolingProblem carPoolingProblem = new CarPoolingProblem(persons);

        Map<Person, Person> matchedPassengersToDrivers = carPoolingProblem.matchPassengersToDrivers();

        // Print the matched passengers and drivers
        System.out.println("\nMatched Passengers to Drivers:");
        for (Map.Entry<Person, Person> entry : matchedPassengersToDrivers.entrySet()) {
            Person driver = entry.getKey();
            Person passenger = entry.getValue();
            System.out.println("Driver: " + driver.getName() + " - Destination: " + driver.getDestination() +
                    " | Passenger: " + passenger.getName() + " - Destination: " + passenger.getDestination());
        }
    }


    // Method to generate a random group of persons with randomly assigned destinations
    private static List<Person> generatePersons(Faker faker) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();

        // Create a list of possible destinations
        List<String> possibleDestinations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            possibleDestinations.add(faker.address().city());
        }

        for (int i = 0; i < 10; i++) { // Assuming 10 persons to generate
            String name = faker.name().fullName();
            int age = faker.number().numberBetween(18, 60); // Assuming age between 18 and 60

            // Randomly select a destination from the list of possible destinations
            String destination = possibleDestinations.get(random.nextInt(10));

            boolean isDriver = random.nextBoolean();

            if (isDriver) {
                List<String> destinations = new ArrayList<>();
                destinations.add(destination);

                // Add 2-3 random destinations for the driver
                for (int j = 0; j < random.nextInt(2) + 2; j++) {
                    String intermediateDestination = possibleDestinations.get(random.nextInt(10));
                    if (!destinations.contains(intermediateDestination)) {
                        destinations.add(intermediateDestination);
                    }
                }

                persons.add(new Driver(name, destinations, age));
            } else {
                persons.add(new Passenger(name, destination, age));
            }
        }

        return persons;
    }

}
