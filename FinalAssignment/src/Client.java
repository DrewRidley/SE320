import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final int portNumber = 16542;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a hostname to connect to. ");
            System.out.print("To connect locally, enter 'localhost' : ");
            String hostName = scanner.next();

            try (Socket socket = new Socket(hostName, portNumber)) {
                // Set up the streams for communication
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                System.out.print("Enter a weight in kilograms: ");
                float weight = scanner.nextFloat();
                System.out.print("\nEnter a height in meters: ");
                float height = scanner.nextFloat();

                while (weight < 1 || weight > 700) {
                    System.out.print("\nYou likely entered an invalid weight.\n Enter the person's weight in kilograms!");
                    weight = scanner.nextFloat();
                }

                while (height < 0.2 || height > 3 ) {
                    System.out.print("\nInvalid height entered. Enter a valid height in meters!");
                    height = scanner.nextFloat();
                }
                

                // Send weight and height to server
                out.println(weight + "," + height);

                // Read the response from the server
                String response = in.readLine();
                System.out.println("Server response: " + response);

                // Cleanup resources
                out.close();
                in.close();
                socket.close();
            } catch (UnknownHostException uhe) {
                System.out.println("The host " + hostName + " was not resolved to an address. Try again...");
            } catch (IOException e) {
                System.out.println("Failed to establish the socket for host: " + hostName);
                e.printStackTrace();
                //Exit from while loop and print exception.
                break;
            }
        }

        scanner.close();
    }
}