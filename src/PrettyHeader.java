/**
 * PrettyHeader.java
 * A program that demonstrates the use of the SafeInput.prettyHeader method
 * to display various messages within a formatted header.
 */
public class PrettyHeader {
    public static void main(String[] args) {
        // Call the prettyHeader method from the SafeInput library with different messages
        System.out.println("--- Testing PrettyHeader with various messages ---");

        SafeInput.prettyHeader("Message Centered Here");
        System.out.println(); // Add a blank line for separation in output

        SafeInput.prettyHeader("Hello World");
        System.out.println(); // Add a blank line for separation in output

        SafeInput.prettyHeader("He's not the messiah, he's a very naughty boy");
        System.out.println(); // Add a blank line for separation in output

        SafeInput.prettyHeader("Short Msg");
        System.out.println(); // Add a blank line for separation in output

        System.out.println("--- End of PrettyHeader Tests ---");
    }
}
