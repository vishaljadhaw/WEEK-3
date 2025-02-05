import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrences {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Specify the file path
        String targetWord = "hello"; // Specify the word to count
        int wordCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }
            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}