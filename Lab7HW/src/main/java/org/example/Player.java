package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player extends Thread {
    private final String playerName;
    private final Bag bag;
    private int maxSequenceValue;
    private volatile boolean myTurn;
    private List<Token> pulledTokens;
    private List<Sequence> sequences;

    public Player(String playerName, Bag bag) {
        this.playerName = playerName;
        this.bag = bag;
        this.maxSequenceValue = 0;
        this.myTurn = false;
        this.pulledTokens = new ArrayList<>();
        this.sequences = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bag) {
                while (!myTurn) {
                    try {
                        bag.wait(); // Wait for my turn
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Token token = bag.extractToken();
                if (token == null) {
                    break;
                }
                pulledTokens.add(token);
                processToken(token);
                myTurn = false;
                bag.notifyAll(); // Notify other players
            }
        }
        System.out.println(playerName + " finished with max sequence value: " + maxSequenceValue);
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    private void processToken(Token token) {
        // Check if the token can extend any existing sequence
        boolean extendedExistingSequence = false;
        for (Sequence sequence : sequences) {
            if (sequence.canExtend(token)) {
                sequence.extend(token);
                extendedExistingSequence = true;
                break;
            }
        }

        // If the token couldn't extend any existing sequence, start a new sequence with it
        if (!extendedExistingSequence) {
            Sequence newSequence = new Sequence();
            newSequence.extend(token);
            sequences.add(newSequence);
        }

        // Update the maxSequenceValue based on the length of the longest sequence
        int maxLength = 0;
        for (Sequence sequence : sequences) {
            maxLength = Math.max(maxLength, sequence.getLength());
        }
        maxSequenceValue = maxLength;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getMaxSequenceValue() {
        return maxSequenceValue;
    }

    public List<Token> getPulledTokens() {
        return pulledTokens;
    }
}
