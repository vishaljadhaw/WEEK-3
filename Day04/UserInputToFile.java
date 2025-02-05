import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // File path where user input will be written
        String filePath = "example.txt"; // Replace with the actual file path

        // Create BufferedReader to read user input from the console
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(filePath, true);  // Use "true" to append to the file
             BufferedWriter writer = new BufferedWriter(fw)) {

            String userInput;
            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            // Keep reading user input until 'exit' is typed
            while (true) {
                userInput = br.readLine(); // Read user input from the console
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;  // Stop input when the user types "exit"
                }
                writer.write(userInput);  // Write the input to the file
                writer.newLine();         // Add a new line in the file after each input
            }

            System.out.println("User input has been written to the file.");
        } catch (IOException e) {
            // Handle any IOException
            e.printStackTrace();
        }
    }
}
