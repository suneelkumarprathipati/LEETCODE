class Solution {
    public int removeDuplicates(int[] nums) {
        for ( int i = 0 ; i < nums.length ; i++ ){
            int count = 1 ;
            for ( int j = i+1 ; j < nums.length ; j++ ){
                if ( nums[i] == nums[j] && count < 2 ){
                    count++;    // limit to 2
                }
                else if ( count >= 2 && nums[i] == nums[j] ){
                    nums[j] = 10001;    // based on constraints
                }
            }
        }
          int length = 0 ;
        for ( int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] != 10001){
                length++;  // count of non duplicates
            }
        }
        Arrays.sort(nums);
        return length;    // length without duplicates
    }
}