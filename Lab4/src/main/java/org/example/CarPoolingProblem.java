package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CarPoolingProblem {
    private List<Person> persons;

    public CarPoolingProblem(List<Person> persons) {
        this.persons = persons;
    }

    // Method to match passengers to drivers with common destination
    public Map<Person, Person> matchPassengersToDrivers() {
        Map<Person, Person> matchedPassengersToDrivers = new HashMap<>();

        // Group passengers by their destination
        Map<String, List<Person>> destinationPassengersMap = persons.stream()
                .filter(person -> person instanceof Passenger)
                .collect(Collectors.groupingBy(Person::getDestination));

        // Group drivers by the destinations they pass through
        Map<String, List<Person>> driverDestinationsMap = persons.stream()
                .filter(person -> person instanceof Driver)
                .flatMap(driver -> ((Driver) driver).getDestinations().stream().map(destination -> new AbstractMap.SimpleEntry<>(destination, driver)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        // Match passengers to drivers
        for (String destination : destinationPassengersMap.keySet()) {
            List<Person> passengers = destinationPassengersMap.get(destination);
            List<Person> drivers = driverDestinationsMap.getOrDefault(destination, new ArrayList<>());

            for (Person driver : drivers) {
                if (!passengers.isEmpty()) {
                    // Pick the first passenger available
                    Person passenger = passengers.get(0);
                    matchedPassengersToDrivers.put(driver, passenger);
                    passengers.remove(passenger); // Remove matched passenger
                }
            }
        }

        return matchedPassengersToDrivers;
    }
}