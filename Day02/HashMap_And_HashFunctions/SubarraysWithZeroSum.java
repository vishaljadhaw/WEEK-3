
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraysWithZeroSum {


   public static List<List<Integer>> findSubarraysWithZeroSum(int[] nums) {
       HashMap<Integer, List<Integer>> map = new HashMap<>();
       List<List<Integer>> result = new ArrayList<>();
       int cumulativeSum = 0;

       for (int i = 0; i < nums.length; i++) {
           cumulativeSum += nums[i];

           if (cumulativeSum == 0) {
               List<Integer> subarray = new ArrayList<>();
               for (int j = 0; j <= i; j++) {
                   subarray.add(nums[j]);
               }
               result.add(subarray);
           }

           if (map.containsKey(cumulativeSum)) {
               List<Integer> indices = map.get(cumulativeSum);
               for (int index : indices) {
                   List<Integer> subarray = new ArrayList<>();
                   for (int j = index + 1; j <= i; j++) {
                       subarray.add(nums[j]);
                   }
                   result.add(subarray);
               }
           }

           map.putIfAbsent(cumulativeSum, new ArrayList<>());
           map.get(cumulativeSum).add(i);
       }

       return result;
   }


   public static void main(String[] args) {
       int[] nums = {6, -2, -3, 4, -1, 3, 2, -2, 2};

       List<List<Integer>> subarrays = findSubarraysWithZeroSum(nums);

       System.out.println("Subarrays with zero sum:");
       for (List<Integer> subarray : subarrays) {
           System.out.println(subarray);
       }
   }
}