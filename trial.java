import java.util.*;

public class trial{


    public static void main(String[] args) {
        int[] arr1 = {9,5,8};
        System.out.println(max(arr1));
    }

    // max: Computes the maximum value in array nums
// PRE: nums.length >= 1
public static int max(int[] nums) {
 return maxR(nums, 0);
}
// maxR (recursive helper function for max)
// Computes the maximum value in the sub-array of nums in positions startLoc
// through nums.length-1
// PRE: nums.length >= 1
private static int maxR(int[] nums, int startLoc) {
 int maxSoFar = 0;
 if (startLoc == nums.length) {
 return maxSoFar;
 }
 if (nums[startLoc] > maxSoFar) {
 maxSoFar = nums[startLoc];
 }
 return maxR(nums, startLoc + 1);
}

}
