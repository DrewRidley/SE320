import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int portNumber = 16542;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.print("Server started. Listening on Port " + portNumber + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + portNumber);
            System.out.println(e.getMessage());
        }
    }
}