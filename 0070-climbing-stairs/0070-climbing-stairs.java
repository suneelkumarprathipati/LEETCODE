class Solution {
    public int climbStairs(int n) {
        int curr,prev1=1,prev2=1;
        for(int i=1;i<n;i++){
            // There are 2 ways to reach this step; take 1 step from previous or 2 steps from 2 steps below
			curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}