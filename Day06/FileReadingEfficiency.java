
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadingEfficiency {

    public static void main(String[] args) {
        // Paths for test files (replace with actual file paths)
        String[] filePaths = {"1mb_file.txt", "100mb_file.txt", "500MBfile.txt"};

        // Testing FileReader
        System.out.println("Testing FileReader:");
        for (String filePath : filePaths) {
            long timeTaken = readUsingFileReader(filePath);
            System.out.println("File: " + filePath + " | Time: " + timeTaken + " ms");
        }

        // Testing InputStreamReader
        System.out.println("\nTesting InputStreamReader:");
        for (String filePath : filePaths) {
            long timeTaken = readUsingInputStreamReader(filePath);
            System.out.println("File: " + filePath + " | Time: " + timeTaken + " ms");
        }
    }

    // Method to read file using FileReader
    private static long readUsingFileReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            while ((character = reader.read()) != -1) {
                // Simulating reading file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    // Method to read file using InputStreamReader
    private static long readUsingInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            int character;
            while ((character = reader.read()) != -1) {
                // Simulating reading file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}


