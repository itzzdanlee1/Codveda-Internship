package level3project2;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    // List of all connected clients
    static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {

        try {
            // Create the server on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Chat Server started...");
            System.out.println("Waiting for clients to connect...");

            while (true) {

                // Wait for a client to connect
                Socket socket = serverSocket.accept();

                System.out.println("A new client has connected!");

                // Create a handler for the client
                ClientHandler client = new ClientHandler(socket);

                // Add client to the list
                clients.add(client);

                // Start a new thread for the client
                client.start();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // Send a message to all connected clients
    public static void broadcast(String message, ClientHandler sender) {

        for (ClientHandler client : clients) {

            // Don't send the message back to the sender
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Remove a client when they disconnect
    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}