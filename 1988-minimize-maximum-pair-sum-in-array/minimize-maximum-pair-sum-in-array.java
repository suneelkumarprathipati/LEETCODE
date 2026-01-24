import java.util.*;
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int max = 0;
        while ( i <= j ){
            int temp = 0;
           temp = nums[i] + nums[j];
           if ( temp > max ) max = temp;
           i++;
           j--;
        }


      //  System.out.print(Arrays.toString(nums));
        return max;
    }
}