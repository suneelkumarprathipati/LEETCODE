class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ret = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length-1; i >= 0 ; i-- )
            s.push(nums[i]);
        for ( int i = nums.length-1 ; i >= 0 ; i-- ){
            while ( s.isEmpty() == false && s.peek() <= nums[i] )
            { s.pop(); }
            int ng = (s.isEmpty()) ? (-1) : s.peek();
            ret[i] = ng;
            s.push(nums[i]);
        }
        return ret;
    }
}