import java.util.Scanner; // Import the Scanner class for input

/**
 * DevTest.java
 * This class serves as a development and testing ground for the static methods
 * in the SafeInput library. Each method will be coded and tested here
 * before being moved to the SafeInput.java file.
 */
public class DevTest {
    public static void main(String[] args) {
        // Create a Scanner object to be used for all input methods
        Scanner in = new Scanner(System.in);

        // --- Test Case for getNonZeroLenString ---
        System.out.println("--- Testing getNonZeroLenString ---");
        String name = SafeInput.getNonZeroLenString(in, "Enter your name (must not be blank)");
        System.out.println("You entered: " + name);
        System.out.println("--- End of getNonZeroLenString Test ---\n");

        // --- Test Case for getInt ---
        System.out.println("--- Testing getInt ---");
        int age = SafeInput.getInt(in, "Enter your age"); // Call SafeInput.getInt
        System.out.println("You entered age: " + age);
        System.out.println("--- End of getInt Test ---\n");

        // --- Test Case for getDouble ---
        System.out.println("--- Testing getDouble ---");
        double salary = SafeInput.getDouble(in, "Enter your salary"); // Call SafeInput.getDouble
        System.out.println("You entered salary: " + salary);
        System.out.println("--- End of getDouble Test ---\n");

        // --- Test Case for getRangedInt ---
        System.out.println("--- Testing getRangedInt ---");
        int birthMonth = SafeInput.getRangedInt(in, "Enter your birth month", 1, 12); // Call SafeInput.getRangedInt
        System.out.println("You entered birth month: " + birthMonth);

        int dayOfMonth = SafeInput.getRangedInt(in, "Enter the day of the month", 1, 31);
        System.out.println("You entered day of month: " + dayOfMonth);

        int year = SafeInput.getRangedInt(in, "Enter a year", 1900, 2025);
        System.out.println("You entered year: " + year);
        System.out.println("--- End of getRangedInt Test ---\n");

        // --- Test Case for getYNConfirm ---
        System.out.println("--- Testing getYNConfirm ---");
        boolean confirmation = SafeInput.getYNConfirm(in, "Do you want to continue (Y/N)"); // Call SafeInput.getYNConfirm
        System.out.println("You confirmed: " + confirmation);

        boolean anotherConfirm = SafeInput.getYNConfirm(in, "Are you sure (Y/N)");
        System.out.println("You are sure: " + anotherConfirm);
        System.out.println("--- End of getYNConfirm Test ---\n");

        // --- Test Case for getRegExString ---
        System.out.println("--- Testing getRegExString ---");
        // For development, we'll place the getRegExString method directly in DevTest first.
        // Once tested, it will be moved to SafeInput.java.

        // Test with a Social Security Number pattern (###-##-####)
        String ssnPattern = "\\d{3}-\\d{2}-\\d{4}";
        String ssn = getRegExString(in, "Enter your Social Security Number (###-##-####)", ssnPattern);
        System.out.println("You entered SSN: " + ssn);

        // Test with a Capital M number pattern (M########)
        String mNumPattern = "[Mm]\\d{8}";
        String mNumber = getRegExString(in, "Enter your M Number (M########)", mNumPattern);
        System.out.println("You entered M Number: " + mNumber);

        // Test with a simple date pattern (MM/DD/YYYY)
        String datePattern = "\\d{2}/\\d{2}/\\d{4}";
        String date = getRegExString(in, "Enter a date (MM/DD/YYYY)", datePattern);
        System.out.println("You entered date: " + date);

        System.out.println("--- End of getRegExString Test ---\n");

        // Close the scanner when all testing is complete
        in.close();
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
