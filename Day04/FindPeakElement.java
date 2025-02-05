public class FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Peak is in the left half (including mid)
            } else {
                left = mid + 1; // Peak is in the right half
            }
        }
        return left; // Index of a peak element
    }
    
    public static void main(String[] args) {
        int[] array = {1, 3, 20, 4, 1, 0}; // Example array
        int peakIndex = findPeakElement(array);
        
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element: " + array[peakIndex]);
    }
}
