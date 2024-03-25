package org.example;

import java.util.List;

public class Driver extends Person{
    private List<String> destinations;

    public Driver(String name, List<String> destinations, int age) {
        super(name, destinations.get(0), age); // Assuming the first destination is the primary destination
        this.destinations = destinations;
    }

    public List<String> getDestinations() {
        return destinations;
    }



}
