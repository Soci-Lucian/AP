package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int TIME_LIMIT_SECONDS = 10;

    public static void main(String[] args) {
        int numberOfPlayers = 4;
        int n = 5;

        List<String> playerNames = new ArrayList<>();
        playerNames.add("Soci");
        playerNames.add("Robert");
        playerNames.add("Andrei");
        playerNames.add("Gabi");

        Bag bag = new Bag(n);
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(playerNames.get(i), bag));
        }

        Timekeeper timekeeper = new Timekeeper(TIME_LIMIT_SECONDS);

        // Start the timekeeper thread before starting player threads
        timekeeper.start();

        // Start player threads
        for (Player player : players) {
            player.start();
        }

        // Set initial turn for the first player
        players.get(0).setMyTurn(true);

        // Wait for the game to finish
        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Stop the game
        timekeeper.stopGame();

        // Display total elapsed time
        System.out.println("Total game time: " + timekeeper.getElapsedTime() + " seconds");

        // Display tokens pulled by each player
        for (Player player : players) {
            System.out.println(player.getPlayerName() + " pulled tokens: " + player.getPulledTokens());
        }

        // Determine the winner
        Player winner = determineWinner(players);
        System.out.println("Winner: " + winner.getPlayerName() + " with max sequence value: " + winner.getMaxSequenceValue());
    }

    private static Player determineWinner(List<Player> players) {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getMaxSequenceValue() > winner.getMaxSequenceValue()) {
                winner = player;
            }
        }
        return winner;
    }
}
