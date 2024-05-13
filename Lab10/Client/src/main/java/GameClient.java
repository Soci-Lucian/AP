import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345; // Change port number if necessary

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Connected to server. Type 'exit' to quit.");

            // Create a separate thread to continuously read messages from the server
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println("Server: " + serverResponse);
                    }
                } catch (IOException e) {
                    System.err.println("Error receiving message from server: " + e.getMessage());
                }
            });
            receiveThread.start();

            // Main thread to send messages to the server
            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
                if (userInputLine.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
