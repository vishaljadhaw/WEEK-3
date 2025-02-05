import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        // File path of the binary data file
        String filePath = "example.txt"; // Replace with the actual file path

        // Use try-with-resources to ensure automatic resource management
        try (FileInputStream fis = new FileInputStream(filePath); 
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // Using UTF-8 charset
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            // Read the file line by line and print the content
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Handle any IOExceptions
            e.printStackTrace();
        }
    }
}
