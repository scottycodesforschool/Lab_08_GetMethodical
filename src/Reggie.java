import java.util.Scanner; // Import the Scanner class to read user input

/**
 * Reggie.java
 * A program that demonstrates the use of the SafeInput.getRegExString method
 * to get various types of user input validated against specific regular expressions.
 */
public class Reggie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object for input

        String ssn;         // To store Social Security Number
        String ucMNum;      // To store UC Student M Number
        String menuChoice;  // To store menu choice

        // --- 1. Get Social Security Number (SSN) ---
        // Pattern: ###-##-####
        // ^\\d{3}-\\d{2}-\\d{4}$
        // ^      - start of the string
        // \\d{3} - exactly three digits
        // -      - a literal hyphen
        // \\d{2} - exactly two digits
        // -      - a literal hyphen
        // \\d{4} - exactly four digits
        // $      - end of the string
        String ssnRegEx = "^\\d{3}-\\d{2}-\\d{4}$";
        System.out.println("--- Social Security Number Input ---");
        ssn = SafeInput.getRegExString(in, "Enter your Social Security Number (###-##-####)", ssnRegEx);
        System.out.println("Valid SSN entered: " + ssn);
        System.out.println("------------------------------------\n");

        // --- 2. Get UC Student M Number ---
        // Pattern: M or m followed by exactly 5 digits
        // ^      - start of the string
        // (M|m)  - 'M' or 'm' (case-insensitive for the first character, but we use ignoreCase in getRegExString)
        //          Wait, the prompt says ^(M|m)\\d{5}$, which means it should match 'M' or 'm' literally.
        //          The prompt says ^(M|m)\\d{5}$ which means M or m followed by exactly 5 digits.
        //          My getRegExString uses String.matches(), which is case-sensitive by default.
        //          So, the pattern should explicitly handle both 'M' and 'm'.
        // \\d{5} - exactly five digits
        // $      - end of the string
        String mNumRegEx = "^[Mm]\\d{5}$"; // Corrected regex for M or m followed by 5 digits
        System.out.println("--- UC Student M Number Input ---");
        ucMNum = SafeInput.getRegExString(in, "Enter your UC Student M Number (Mxxxxx or mxxxxx)", mNumRegEx);
        System.out.println("Valid M Number entered: " + ucMNum);
        System.out.println("---------------------------------\n");

        // --- 3. Get Menu Choice ---
        // Pattern: A single character that is O, S, V, or Q (case-insensitive)
        // ^      - start of the string
        // [OoSsVvQq] - any single character from this set (O, o, S, s, V, v, Q, q)
        // $      - end of the string
        String menuRegEx = "^[OoSsVvQq]$";
        System.out.println("--- Menu Choice Input ---");
        menuChoice = SafeInput.getRegExString(in, "Enter your menu choice (O, S, V, Q)", menuRegEx);
        System.out.println("Valid menu choice entered: " + menuChoice);
        System.out.println("-------------------------\n");

        in.close(); // Close the scanner
    }
}
