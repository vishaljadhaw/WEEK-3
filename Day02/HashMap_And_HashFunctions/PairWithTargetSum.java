

import java.util.HashSet;

public class PairWithTargetSum {


   public static boolean hasPairWithSum(int[] nums, int target) {
       HashSet<Integer> seen = new HashSet<>();

       for (int num : nums) {
         
           int complement = target - num;

           if (seen.contains(complement)) {
               return true;
           }

      
           seen.add(num);
       }

       return false;
   }

   public static void main(String[] args) {
       int[] nums = {10, 15, 3, 7};
       int target = 17;

       System.out.println("Pair with target sum exists: " + hasPairWithSum(nums, target));
   }
}