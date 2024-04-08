package org.example;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfPlayers = 4;
        int n = 4; // For example purposes

        List<String> playerNames = new ArrayList<>();
        playerNames.add("Soci");
        playerNames.add("Gabi");
        playerNames.add("Enrico");
        playerNames.add("Robert");

        Bag bag = new Bag(n);
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(playerNames.get(i), bag, n);
            players.add(player);
        }
        for (Player player : players) {
            player.start();
        }
        try {
            // Wait for all player threads to finish execution
            for (Player player : players) {
                player.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Player player : players) {
            System.out.println(player.getPlayerName() + " scored " + player.getMaxPoints() + " points with sequence: " + player.getMaxSequence());
        }
    }
}
