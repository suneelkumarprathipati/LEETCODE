import java.util.*;
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[nums.length];
        for ( int i = 0 ; i < nums.length ; i++ ){
            for ( int j = 0 ; j < nums.length ; j++ ){
                if ( nums[i] == nums[j] )
                    arr[i]++;
            }
            System.out.print(arr[i]);
        }
        int max = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( arr[i] > max ) max = arr[i];
            System.out.print(max);
        }
        int count = 0;
        for ( int i = 0 ; i < nums.length ; i++ ){
            if ( max == arr[i] ) count++;
        }
        System.out.print(count);
        return count;
    }
}