// Drew Ridley:
// SE320
// Assignment 3, Problem 3 10/3/23.
public class Prob3 {
    public static void main(String[] args) {
        //Prompt user to enter number between 0-10.
        System.out.print("Enter a number between 0 and 10: ");
        int num = Integer.parseInt(System.console().readLine());
        assert (num <= 10 && num >= 0) : "Number must be between 0 and 10!";
        System.out.println("You entered: " + num);
    }
}
