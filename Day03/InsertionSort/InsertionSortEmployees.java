
import java.util.Arrays;

public class InsertionSortEmployees {
    public static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            
            // Move elements of ids[0..i-1], that are greater than key,
            // one position ahead of their current position
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {105, 102, 110, 101, 108};
        
        System.out.println("Unsorted Employee IDs:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();
        
        insertionSort(employeeIds);
        
        System.out.println("Sorted Employee IDs:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}

