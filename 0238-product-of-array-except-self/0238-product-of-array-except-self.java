class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] temp = new int[nums.length ];
        int lp = 1 , rp = 1;
        for ( int i = 0 ; i < nums.length ; i++ ){
            temp[i] = lp;
            lp *= nums[i];
        }
        for ( int i = nums.length-1 ; i >= 0 ; i-- ){
            temp[i] = rp * temp[i];
            rp *= nums[i];
        }
        return temp;
    }
}