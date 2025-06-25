import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                try (
                    DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())
                ) {
                    String message = dis.readUTF();
                    System.out.println("Received: " + message);

                    String response = message.toUpperCase();
                    dos.writeUTF(response);
                    System.out.println("Sent: " + response);
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                } finally {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}
