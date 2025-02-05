import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    public static String removeDuplicates(String input) {
        // Initialize an empty StringBuilder
        StringBuilder sb = new StringBuilder();

        // Initialize a HashSet to keep track of characters
        HashSet<Character> seen = new HashSet<>();

        // Iterate over each character in the string
        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {
                sb.append(ch); // Append to StringBuilder
                seen.add(ch); // Add to HashSet
            }
        }

        // Return the StringBuilder as a string without duplicates
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String input = "hello";
        String result = removeDuplicates(input);

        // Print the string without duplicates
        System.out.println("String without duplicates: " + result);
    }
}
