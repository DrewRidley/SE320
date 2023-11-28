package Assignment5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DaysAlive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their birth date
        System.out.println("Enter your birth year: ");
        int birthYear = scanner.nextInt();

        System.out.println("Enter your birth month: ");
        int birthMonth = scanner.nextInt();

        System.out.println("Enter your birth day: ");
        int birthDay = scanner.nextInt();

        Day birthDate = new Day(birthYear, birthMonth, birthDay);

        // Get current date.
        LocalDate currentDate = LocalDate.now();
        Day today = new Day(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());

        int daysSinceBirth = today.daysFrom(birthDate);

        System.out.println("Number of days since birth: " + daysSinceBirth);

        scanner.close();
    }
}