import java.util.Scanner; // Import the Scanner class for input

/**
 * DevTest.java
 * This class serves as a development and testing ground for the static methods
 * in the SafeInput library. All SafeInput methods are called directly from
 * the SafeInput.java file, demonstrating their usage.
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
        String ssnPattern = "^\\d{3}-\\d{2}-\\d{4}$";
        String ssn = SafeInput.getRegExString(in, "Enter your Social Security Number (###-##-####)", ssnPattern);
        System.out.println("You entered SSN: " + ssn);

        String mNumPattern = "^[Mm]\\d{5}$";
        String mNumber = SafeInput.getRegExString(in, "Enter your M Number (Mxxxxx or mxxxxx)", mNumPattern);
        System.out.println("You entered M Number: " + mNumber);

        String menuRegEx = "^[OoSsVvQq]$";
        String menuChoice = SafeInput.getRegExString(in, "Enter your menu choice (O, S, V, Q)", menuRegEx);
        System.out.println("Valid menu choice entered: " + menuChoice);
        System.out.println("--- End of getRegExString Test ---\n");

        // --- Test Case for prettyHeader ---
        System.out.println("--- Testing prettyHeader ---");
        SafeInput.prettyHeader("Message Centered Here");
        System.out.println(); // Add a blank line for separation in output

        SafeInput.prettyHeader("Hello World");
        System.out.println(); // Add a blank line for separation in output

        SafeInput.prettyHeader("A very long message that might not fit perfectly"); // Test with a longer message
        System.out.println(); // Add a blank line for separation in output

        SafeInput.prettyHeader("Short Msg"); // Test with a shorter message
        System.out.println(); // Add a blank line for separation in output

        System.out.println("--- End of prettyHeader Test ---\n");

        // Close the scanner when all testing is complete
        in.close();
    }
}
