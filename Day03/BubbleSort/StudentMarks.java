import java.util.Scanner;

public class StudentMarks{

    // Method to print the sorted marks array
    public static void bubbleSort(int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " "); // Print each mark
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input

        // Taking input for the number of students
        System.out.println("Enter the number of students");
        int numberOfStudent = sc.nextInt();

        // Creating an array to store student marks
        int arr[] = new int[numberOfStudent];

        // Taking input for student marks
        for (int i = 0; i < numberOfStudent; i++) {
            System.out.println("Enter the marks of student " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        System.out.println("Student marks in ascending order:");

        // Implementing Bubble Sort algorithm
        for (int i = 0; i < arr.length - 1; i++) { // Outer loop for passes
            for (int j = 0; j < arr.length - i - 1; j++) { // Inner loop for comparisons
                if (arr[j] > arr[j + 1]) { // Swap if the current element is greater than the next element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Calling the method to print the sorted array
        bubbleSort(arr);

        sc.close(); // Closing the scanner to prevent resource leaks
    }
}