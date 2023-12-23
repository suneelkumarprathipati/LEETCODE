class Solution {
     public  int findMin(int[] nums) {
        return min( nums , 0 ,nums[0] );
    }
    static int min( int[] arr , int i , int mini  ){
        if ( i == arr.length ) return mini;
        if ( mini > arr[i] ) return min(arr,i+1,arr[i]);
        else return min(arr,i+1,mini);
    }
}