import java.util.InputMismatchException;
import java.util.Scanner;

public class SumTwoIntegers {
    public static int getInteger(Scanner scan, String message) {
        while (true) {
            try {
                System.out.print(message);
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Enter again: ");
                scan.nextLine(); // Clear inputs.
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        num1 = getInteger(scanner, "Enter the first integer: ");
        num2 = getInteger(scanner, "Enter the second integer: ");

        System.out.println("Sum: " + (num1 + num2));

        scanner.close();
    }
}