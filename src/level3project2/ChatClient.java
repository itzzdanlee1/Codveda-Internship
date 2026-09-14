package level3project2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            // Connect to the server
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to the chat server!");

            // Receive messages from server
            BufferedReader serverInput = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Send messages to server
            PrintWriter serverOutput = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

            // Get username
            System.out.print("Enter your username: ");
            String username = input.nextLine();

            serverOutput.println(username);

            // Thread for receiving messages
            Thread receiveThread = new Thread(() -> {

                try {

                    String message;

                    while ((message = serverInput.readLine()) != null) {
                        System.out.println("\n" + message);
                        System.out.print("You: ");
                    }

                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });

            // Start receiving thread
            receiveThread.start();

            // Send messages
            while (true) {

                System.out.print("You: ");
                String message = input.nextLine();

                serverOutput.println(message);

                // Exit the chat
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Close connection
            socket.close();
            input.close();

        } catch (IOException e) {

            System.out.println("Could not connect to server.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}