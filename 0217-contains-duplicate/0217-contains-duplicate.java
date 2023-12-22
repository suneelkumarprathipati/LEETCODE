class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ret = new HashSet<>();
        ret.add(nums[0]);
        for ( int i = 1 ; i < nums.length ; i++ ){
            if ( ret.contains(nums[i])){
               return true;
            }
            else  ret.add(nums[i]);
        }
        return false;
    }
}