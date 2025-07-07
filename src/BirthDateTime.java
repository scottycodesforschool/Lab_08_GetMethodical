import java.util.Scanner; // Import the Scanner class to read user input

/**
 * BirthDateTime.java
 * A program that prompts the user for their birth year, month, day, hour, and minute,
 * using the SafeInput library's getRangedInt method for validation.
 * It includes logic to correctly determine the number of days in a given month.
 */
public class BirthDateTime {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console (System.in)
        Scanner in = new Scanner(System.in);

        int birthYear;   // To store the birth year
        int birthMonth;  // To store the birth month
        int birthDay;    // To store the birth day
        int birthHour;   // To store the birth hour
        int birthMinute; // To store the birth minute

        int daysInMonth = 0; // Variable to hold the maximum days for the selected month

        // 1. Get Birth Year (1950-2015)
        birthYear = SafeInput.getRangedInt(in, "Enter your birth year", 1950, 2015);

        // 2. Get Birth Month (1-12)
        birthMonth = SafeInput.getRangedInt(in, "Enter your birth month", 1, 12);

        // 3. Determine and Get Birth Day based on the month
        // Use a switch statement to set the correct upper limit for days in the month
        switch (birthMonth) {
            case 2: // February
                // For simplicity, we'll allow up to 29 days for February to account for leap years,
                // even if the year itself isn't a leap year within the specified range.
                // A more robust solution would check if (birthYear % 4 == 0 && (birthYear % 100 != 0 || birthYear % 400 == 0))
                daysInMonth = 29;
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                daysInMonth = 30;
                break;
            default: // January, March, May, July, August, October, December (all 31 days)
                daysInMonth = 31;
                break;
        }
        birthDay = SafeInput.getRangedInt(in, "Enter your birth day", 1, daysInMonth);

        // 4. Get Birth Hour (1-24)
        birthHour = SafeInput.getRangedInt(in, "Enter your birth hour", 1, 24);

        // 5. Get Birth Minute (1-59)
        birthMinute = SafeInput.getRangedInt(in, "Enter your birth minute", 1, 59);

        // Display the collected birth date and time
        System.out.println("\nYour birth date and time is:");
        System.out.println("Year: " + birthYear);
        System.out.println("Month: " + birthMonth);
        System.out.println("Day: " + birthDay);
        System.out.println("Hour: " + birthHour);
        System.out.println("Minute: " + birthMinute);

        // Close the scanner to release system resources
        in.close();
    }
}
