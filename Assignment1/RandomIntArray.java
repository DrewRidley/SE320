import java.util.Random;
import java.util.Scanner;

public class RandomIntArray {
    public static void main(String[] args) {
        int[] randomArray = new int[100];
        Random random = new Random();

        // Fill the array with random integers
        for (int i = 0; i < 100; i++) {
            randomArray[i] = random.nextInt(1000); // Random integers between 0 and 999
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter an index (0-99) to get the corresponding element: ");
                int index = scanner.nextInt();

                if (index < 0 || index >= 100) {
                    System.out.println("Out of Bounds");
                } else {
                    System.out.println("Element at index " + index + ": " + randomArray[index]);
                }
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid index (0-99).");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.close();
    }
}