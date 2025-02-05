public class ReverseStringUsingStringBuilder {
    public static String reverseString(String input) {
        // Create a new StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Append the string to the StringBuilder
        sb.append(input);

        // Use the reverse() method of StringBuilder to reverse the string
        sb.reverse();

        // Convert the StringBuilder back to a string and return it
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String input = "hello";
        String reversed = reverseString(input);

        // Print the reversed string
        System.out.println("Reversed String: " + reversed);
    }
}
