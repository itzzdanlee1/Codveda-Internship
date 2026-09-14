package level3project2;



import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {
            // Receive messages from the client
            input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Send messages to the client
            output = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

        } catch (IOException e) {
            System.out.println("Error creating client handler.");
        }
    }

    @Override
    public void run() {

        try {

            // Ask the client for their name
            output.println("Enter your username:");

            String username = input.readLine();

            System.out.println(username + " has joined the chat.");

            // Tell other clients that a new user joined
            ChatServer.broadcast(
                    username + " has joined the chat.",
                    this
            );

            String message;

            // Keep receiving messages
            while ((message = input.readLine()) != null) {

                // Check if user wants to leave
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                // Display message on server
                System.out.println(username + ": " + message);

                // Send message to all other clients
                ChatServer.broadcast(
                        username + ": " + message,
                        this
                );
            }

        } catch (IOException e) {

            System.out.println("Client disconnected.");

        } finally {

            try {
                // Remove client from the list
                ChatServer.removeClient(this);

                // Close the connection
                socket.close();

            } catch (IOException e) {
                System.out.println("Error closing connection.");
            }
        }
    }

    // Send a message to this client
    public void sendMessage(String message) {
        output.println(message);
    }
}