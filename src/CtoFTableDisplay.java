/**
 * CtoFTableDisplay.java
 * A program that displays a table of Celsius to Fahrenheit conversions
 * from -100 to 100 degrees Celsius. It uses a static method to perform the conversion.
 */
public class CtoFTableDisplay {
    public static void main(String[] args) {
        // Display a header for the table
        System.out.println("Celsius to Fahrenheit Conversion Table");
        System.out.println("------------------------------------");
        System.out.printf("%-10s %-15s\n", "Celsius", "Fahrenheit"); // Table headers
        System.out.println("------------------------------------");

        // Loop from -100 to 100 degrees Celsius
        for (int celsius = -100; celsius <= 100; celsius++) {
            // Convert Celsius to Fahrenheit using the CtoF method
            double fahrenheit = CtoF(celsius);

            // Display the Celsius and Fahrenheit values in a tabular format
            // %-10d for left-aligned integer with 10 spaces
            // %-15.2f for left-aligned double with 15 spaces and 2 decimal places
            System.out.printf("%-10d %-15.2f\n", celsius, fahrenheit);
        }

        System.out.println("------------------------------------");
        System.out.println("Conversion table complete.");
    }

    /**
     * Converts a temperature value from Celsius to Fahrenheit.
     * Formula: F = (C * 9/5) + 32
     *
     * @param celsius The temperature in Celsius.
     * @return The equivalent temperature in Fahrenheit.
     */
    public static double CtoF(double celsius) {
        return (celsius * 9/5) + 32;
    }
}
