package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Thread {
    private String playerName;
    private Bag bag;
    private int n;
    private List<Token> maxSequence;
    private int maxPoints;
    private int points;

    public Player(String playerName, Bag bag, int n) {
        this.playerName = playerName;
        this.bag = bag;
        this.n = n;
        this.maxSequence = new ArrayList<>();
        this.maxPoints = 0;
        this.points = 0;
    }

    private boolean isValidSequence(List<Token> sequence) {
        if (sequence.size() != n) {
            return false;
        }

        boolean[] visited = new boolean[n + 1]; // Array to track visited numbers
        int[] next = new int[n + 1]; // Array to track next numbers
        for (Token token : sequence) {
            int number1 = token.getNumber1();
            int number2 = token.getNumber2();
            // Check if numbers are within valid range and not already visited
            if (number1 < 1 || number1 > n || number2 < 1 || number2 > n || visited[number1] || visited[number2]) {
                return false;
            }
            visited[number1] = true;
            visited[number2] = true;
            // Mark the next number in the sequence
            next[number1] = number2;
        }

        // Check if the sequence forms a closed loop
        int current = sequence.get(0).getNumber1();
        for (int i = 0; i < n; i++) {
            if (next[current] == 0 || visited[next[current]]) {
                return false;
            }
            visited[next[current]] = true;
            current = next[current];
        }

        // Check if the last number connects back to the first number
        return current == sequence.get(0).getNumber1();
    }


    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                List<Token> sequence = new ArrayList<>();
                synchronized (bag) {
                    while (sequence.size() < n) {
                        Token token = bag.extractToken();
                        if (token == null) {
                            return; // No more tokens available, exit gracefully
                        }
                        sequence.add(token);
                    }
                }
                System.out.println(playerName + " pulled tokens: " + sequence);
                if (isValidSequence(sequence)) {
                    int value = sequence.size();
                    synchronized (this) {
                        if (value > maxPoints) {
                            maxPoints = value;
                            maxSequence = sequence;
                        }
                    }
                }
                synchronized (this) {
                    System.out.println(playerName + " scored " + maxPoints + " points with sequence: " + maxSequence);
                }
                Thread.sleep(new Random().nextInt(1000)); // Simulating player's processing time
            }
        } catch (InterruptedException e) {
            // Restore interrupted status
            Thread.currentThread().interrupt();
        }
    }


    public String getPlayerName() {
        return playerName;
    }

    public List<Token> getMaxSequence() {
        return maxSequence;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
}
