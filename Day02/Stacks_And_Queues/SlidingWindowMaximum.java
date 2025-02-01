import java.util.*;

public class SlidingWindowMaximum {

    // Function to find the maximum element in each sliding window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        // Result array to store the maximum values for each window
        int[] result = new int[nums.length - k + 1];
        
        // Deque to store indices of useful elements for the current window
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements from the back of deque if they are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add the current index to the deque
            deque.offer(i);
            
            // Remove the index from the front if it's out of the window
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // The front of the deque is the maximum element in the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test case
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        
        // Output the result
        System.out.println(Arrays.toString(result));  // Output: [3, 3, 5, 5, 6, 7]
    }
}
