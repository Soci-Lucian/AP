package org.example;

public class Timekeeper extends Thread {
    private final int timeLimitSeconds;
    private long startTime;
    private volatile boolean gameRunning;
    private volatile boolean timeLimitExceeded;
    private long elapsedTime;

    public Timekeeper(int timeLimitSeconds) {
        this.timeLimitSeconds = timeLimitSeconds;
        this.gameRunning = true;
        this.timeLimitExceeded = false;
        this.elapsedTime = 0;
        setDaemon(true);
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while (gameRunning) {
            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
            if (elapsedTime >= timeLimitSeconds) {
                stopGame();
                timeLimitExceeded = true;
                System.out.println("Time limit exceeded. Game stopped.");
                System.exit(0);
            }
        }
    }

    public void stopGame() {
        gameRunning = false;
    }

    public boolean isTimeLimitExceeded() {
        return timeLimitExceeded;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
