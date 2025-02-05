public class LinearSearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the list of sentences
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }
    
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "This is a simple example of linear search."
        };
        
        String word = "Java"; // Word to search for
        String result = findSentenceWithWord(sentences, word);
        
        System.out.println("Sentence containing the word: " + result);
    }
}
