import java.util.Scanner;

/**
 * CheckOut.java
 * A program to calculate the total cost of items purchased at a "$10 Store".
 * It uses SafeInput methods to get item prices within a range and confirm
 * if the user has more items.
 */
public class CheckOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object for input
        double totalCost = 0.0;             // Variable to accumulate the total cost
        boolean moreItems = true;           // Flag to control the loop for adding more items

        System.out.println("--- Welcome to the $10 Store Checkout ---");

        do {
            // Get the price of the current item using getRangedDouble
            // Item prices must be between 0.50 and 10.00 dollars inclusive.
            double itemPrice = SafeInput.getRangedDouble(in, "Enter the price of your item", 0.50, 10.00);

            totalCost += itemPrice; // Add the item price to the total cost

            // Ask the user if they have more items using getYNConfirm
            moreItems = SafeInput.getYNConfirm(in, "Do you have more items to add");

        } while (moreItems); // Continue the loop as long as the user confirms they have more items

        // Display the total cost formatted to two decimal places
        System.out.printf("\nTotal cost of your items: $%.2f\n", totalCost);

        in.close(); // Close the scanner
    }
}
