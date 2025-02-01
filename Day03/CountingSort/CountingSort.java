
public class CountingSort {

    // Function to perform counting sort
    public static void countingSort(int[] ages) {
        int maxAge = 18;  // Maximum possible age
        int minAge = 10;  // Minimum possible age

        // Create a count array to store the frequency of each age
        int[] count = new int[maxAge - minAge + 1];

        // Store the frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Modify the count array to store the cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Create an output array to store sorted ages
        int[] output = new int[ages.length];

        // Place each age in its correct position in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy the sorted ages back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Function to print the array of ages
    public static void printArray(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 17, 13, 18, 14, 11, 16, 15};
        System.out.println("Original Student Ages:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("Sorted Student Ages:");
        printArray(studentAges);
    }
}

