import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
             
            String receivedData = in.readLine();
            String[] tokens = receivedData.split(",");
            double weight = Double.parseDouble(tokens[0]);
            double height = Double.parseDouble(tokens[1]);
            double bmi = weight / (height * height);
            
            out.println("Your BMI is: " + bmi);

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen for a connection");
            System.out.println(e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}