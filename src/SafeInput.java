import java.util.Scanner;

/**
 * A library of static methods for safe user input.
 * These methods ensure that user input meets specific criteria
 * before returning it to the calling program.
 */
public class SafeInput {

    /**
     * Prompts the user for a string and ensures it is not empty.
     * The method will loop until a non-empty string is entered.
     *
     * @param pipe   The Scanner object to read input from, typically System.in.
     * @param prompt The message displayed to the user before input.
     * @return A non-empty String entered by the user.
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0); // Continue looping until a non-empty string is received

        return retString; // Return the valid non-empty string
    }

    /**
     * Prompts the user for an integer and ensures valid integer input.
     * The method will loop until a valid integer is entered.
     * It handles non-integer input and clears the buffer.
     *
     * @param pipe   The Scanner object to read input from.
     * @param prompt The message displayed to the user before input.
     * @return A valid integer entered by the user.
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;   // Variable to store the valid integer
        boolean done = false; // Flag to control the input loop
        String trash = "";    // Variable to catch invalid input

        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            if (pipe.hasNextInt()) { // Check if the next token is an integer
                retInt = pipe.nextInt(); // Read the integer
                pipe.nextLine(); // Clear the buffer (consume the newline character)
                done = true; // Set done to true as valid input was received
            } else {
                trash = pipe.nextLine(); // Read the invalid input as a string
                System.out.println("Invalid input: '" + trash + "'. Please enter an integer.");
            }
        } while (!done); // Continue looping until a valid integer is received

        return retInt; // Return the valid integer
    }

    /**
     * Prompts the user for a double and ensures valid double input.
     * The method will loop until a valid double is entered.
     * It handles non-double input and clears the buffer.
     *
     * @param pipe   The Scanner object to read input from.
     * @param prompt The message displayed to the user before input.
     * @return A valid double entered by the user.
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0.0; // Variable to store the valid double
        boolean done = false;   // Flag to control the input loop
        String trash = "";      // Variable to catch invalid input

        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            if (pipe.hasNextDouble()) { // Check if the next token is a double
                retDouble = pipe.nextDouble(); // Read the double
                pipe.nextLine(); // Clear the buffer (consume the newline character)
                done = true; // Set done to true as valid input was received
            } else {
                trash = pipe.nextLine(); // Read the invalid input as a string
                System.out.println("Invalid input: '" + trash + "'. Please enter a valid number.");
            }
        } while (!done); // Continue looping until a valid double is received

        return retDouble; // Return the valid double
    }

    /**
     * Prompts the user for an integer within a specified inclusive range.
     * The method will loop until a valid integer within the range is entered.
     * It handles non-integer input and out-of-range input, clearing the buffer.
     *
     * @param pipe   The Scanner object to read input from.
     * @param prompt The message displayed to the user before input.
     * @param low    The lower bound of the inclusive range.
     * @param high   The upper bound of the inclusive range.
     * @return A valid integer within the specified range.
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;   // Variable to store the valid integer
        boolean done = false; // Flag to control the input loop
        String trash = "";    // Variable to catch invalid input

        do {
            // Append the range to the prompt
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) { // Check if the next token is an integer
                retInt = pipe.nextInt(); // Read the integer
                pipe.nextLine(); // Clear the buffer (consume the newline character)

                // Check if the integer is within the specified range
                if (retInt >= low && retInt <= high) {
                    done = true; // Set done to true as valid input was received
                } else {
                    System.out.println("Input is out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                trash = pipe.nextLine(); // Read the invalid input as a string
                System.out.println("Invalid input: '" + trash + "'. Please enter an integer.");
            }
        } while (!done); // Continue looping until a valid integer within the range is received

        return retInt; // Return the valid integer
    }

    /**
     * Prompts the user for a Yes or No [Y/N] input, returning true for yes and false for no.
     * It accepts 'y', 'Y', 'n', 'N' as valid responses and loops until one of them is entered.
     *
     * @param pipe   The Scanner object to read input from.
     * @param prompt The message displayed to the user before input.
     * @return true if 'Y' or 'y' is entered, false if 'N' or 'n' is entered.
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean done = false; // Flag to control the input loop
        String input = "";    // Variable to store the user's input
        boolean confirmation = false; // Variable to store the boolean result

        do {
            System.out.print("\n" + prompt + " [Y/N]: "); // Display the prompt with [Y/N]
            input = pipe.nextLine(); // Read the entire line of input

            if (input.equalsIgnoreCase("Y")) { // Check for 'Y' or 'y'
                confirmation = true;
                done = true;
            } else if (input.equalsIgnoreCase("N")) { // Check for 'N' or 'n'
                confirmation = false;
                done = true;
            } else {
                System.out.println("Invalid input: '" + input + "'. Please enter 'Y' or 'N'.");
            }
        } while (!done); // Continue looping until a valid Y/N response is received

        return confirmation; // Return the boolean confirmation
    }

    /**
     * Prompts the user to input a String that matches a given regular expression pattern.
     * The method will loop until a valid string matching the pattern is entered.
     *
     * @param pipe   The Scanner object to read input from.
     * @param prompt The message displayed to the user before input.
     * @param regEx  The regular expression pattern to match.
     * @return A String that matches the specified regular expression.
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = ""; // Variable to store the user's input
        boolean done = false;  // Flag to control the input loop

        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            retString = pipe.nextLine(); // Read the entire line of input

            if (retString.matches(regEx)) { // Check if the input matches the regex pattern
                done = true; // If it matches, set done to true to exit the loop
            } else {
                System.out.println("Invalid input: '" + retString + "'. Input must match the pattern: " + regEx);
            }
        } while (!done); // Continue looping until a valid string matching the regex is received

        return retString; // Return the valid string
    }
}
