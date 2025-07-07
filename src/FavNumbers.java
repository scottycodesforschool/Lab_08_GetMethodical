import java.util.Scanner; // Import the Scanner class to read user input

/**
 * FavNumbers.java
 * A program that prompts the user for their favorite integer and favorite double
 * using the SafeInput library to ensure valid numeric input.
 */
public class FavNumbers {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console (System.in)
        Scanner in = new Scanner(System.in);

        int favInt;    // Variable to store the user's favorite integer
        double favDouble; // Variable to store the user's favorite double

        // Prompt the user for their favorite integer using SafeInput.getInt
        favInt = SafeInput.getInt(in, "Enter your favorite integer");

        // Prompt the user for their favorite double using SafeInput.getDouble
        favDouble = SafeInput.getDouble(in, "Enter your favorite double");

        // Display the entered favorite numbers
        System.out.println("\nYour favorite integer is: " + favInt);
        System.out.println("Your favorite double is: " + favDouble);

        // Close the scanner to release system resources
        in.close();
    }
}
