import java.util.Arrays;

public class SearchChallenge {
    
    // Method to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Rearrange elements so that nums[i] is at the position nums[i] - 1 if it's in the range [1, n]
        for (int i = 0; i < n; i++) {
            // Swap elements if the current element is positive and within the valid range
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        // After rearranging, the first index where the value is not equal to i + 1 is the missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // Return the first missing positive number
            }
        }
        
        // If all numbers from 1 to n are present, the missing number is n + 1
        return n + 1;
    }
    
    // Binary search method to find the index of a target value in a sorted array
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        // Continue searching while left pointer is less than or equal to right pointer
        while (left <= right) {
            // Find the middle index of the current search range
            int mid = left + (right - left) / 2;
            
            // If the target value is found, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // If the target is greater than the mid value, search in the right half
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            // If the target is smaller than the mid value, search in the left half
            else {
                right = mid - 1;
            }
        }
        
        // If the target is not found, return -1
        return -1;
    }
    
    public static void main(String[] args) {
        // Test case for findFirstMissingPositive method
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + findFirstMissingPositive(nums));
        
        // Test case for binarySearch method
        int[] sortedNums = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        System.out.println("Index of target: " + binarySearch(sortedNums, target));
    }
}
