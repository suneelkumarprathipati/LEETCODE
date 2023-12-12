class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (int)(nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}