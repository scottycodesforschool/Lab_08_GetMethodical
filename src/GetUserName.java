import java.util.Scanner; // Import the Scanner class to read user input

/**
 * A simple program to get the user's first and last name
 * using the SafeInput library to ensure non-empty input.
 */
public class GetUserName {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console (System.in)
        Scanner in = new Scanner(System.in);

        String firstName = ""; // Variable to store the user's first name
        String lastName = "";  // Variable to store the user's last name

        // Use SafeInput.getNonZeroLenString to get the first name,
        // ensuring it's not a blank string.
        firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");

        // Use SafeInput.getNonZeroLenString to get the last name,
        // ensuring it's not a blank string.
        lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");

        // Print the full name to the console
        System.out.println("\nYour full name is: " + firstName + " " + lastName);

        // Close the scanner to release system resources
        in.close();
    }
}
