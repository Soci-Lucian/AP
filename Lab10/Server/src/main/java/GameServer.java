import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private int port;
    private boolean running;
    private ServerSocket serverSocket;

    public GameServer(int port) {
        this.port = port;
        this.running = false;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            running = true;
            System.out.println("Server started on port " + port);
            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
            }
        } catch (IOException e) {
            if (!running) {
                System.out.println("Server stopped");
            } else {
                System.err.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }

    public void stopServer() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error stopping server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int port = 12345; // Change port number as needed
        GameServer server = new GameServer(port);
        server.start();
    }
}
