public class ConcatenateStringsUsingStringBuffer {
    public static String concatenateStrings(String[] strings) {
        // Create a new StringBuffer object
        StringBuffer sb = new StringBuffer();
        
        // Iterate through each string in the array and append it to the StringBuffer
        for (String str : strings) {
            sb.append(str);
        }
        
        // Return the concatenated string
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Example usage
        String[] input = {"Hello", " ", "World", "!"};
        String result = concatenateStrings(input);
        
        // Print the concatenated string
        System.out.println("Concatenated String: " + result);
    }
}
