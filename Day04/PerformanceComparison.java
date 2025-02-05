import java.io.*;
import java.util.StringTokenizer;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        countWordsUsingFileReader("example.txt");  // Update with actual file path
        countWordsUsingInputStreamReader("example.txt"); // Update with actual file path
    }

    private static void compareStringBuilderAndBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        // Measure StringBuilder time
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long sbTime = System.nanoTime() - startTime;

        // Measure StringBuffer time
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long sbfTime = System.nanoTime() - startTime;

        System.out.println("StringBuilder Time: " + (sbTime / 1_000_000) + " ms");
        System.out.println("StringBuffer Time: " + (sbfTime / 1_000_000) + " ms");
    }

    private static void countWordsUsingFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
            System.out.println("Words counted using FileReader: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error reading file using FileReader: " + e.getMessage());
        }
    }

    private static void countWordsUsingInputStreamReader(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
            System.out.println("Words counted using InputStreamReader: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error reading file using InputStreamReader: " + e.getMessage());
        }
    }
}
