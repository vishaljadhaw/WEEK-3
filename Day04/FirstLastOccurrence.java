public class FirstLastOccurrence {
    public static int[] findFirstLast(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }
    
    private static int findBound(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1, bound = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                bound = mid;
                if (first) {
                    right = mid - 1; // Search left half for first occurrence
                } else {
                    left = mid + 1; // Search right half for last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] result = findFirstLast(nums, target);
        
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }
}
