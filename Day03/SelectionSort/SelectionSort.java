
public class SelectionSort {
    public static void selectionSort(int[] scores) {
        // Loop through the array
        for (int i = 0; i < scores.length - 1; i++) {
            // Find the index of the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void printArray(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] examScores = {89, 95, 72, 56, 45, 63};
        System.out.println("Original Exam Scores:");
        printArray(examScores);

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores:");
        printArray(examScores);
    }
}

