import java.util.HashMap;

public class TwoSum {
    
    // Function to find two indices whose values add up to the target
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the value and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement is in the map
            if (map.containsKey(complement)) {
                // Return the indices of the two elements
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current element to the map
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution exists
        return new int[] {};
    }
    
    public static void main(String[] args) {
        // Test case
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        // Get the indices of the two elements that sum up to the target
        int[] result = twoSum(nums, target);
        
        if (result.length > 0) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
