class Solution {
    int[] nums1, nums2;
    int[][] dp;
    private int getProd(int[] arr, int val, int idx) {
        int prod = val * arr[idx];
        for(int x = idx; x < arr.length; x++) {
            prod = Math.max(val * arr[x], prod);
        }
        return prod;
    }
    private int solve(int i, int j) {
        if(i == nums1.length || j == nums2.length) {
            return Integer.MIN_VALUE;
        } else if(i == nums1.length-1) {
            return getProd(nums2, nums1[i], j);
        } else if(j == nums2.length-1) {
            return getProd(nums1, nums2[j], i);
        }
        if(dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int prod = nums1[i] * nums2[j];
        int res = solve(i+1, j+1);
        res = Math.max(res, Math.max(prod, res+prod));
        res = Math.max(res, solve(i, j+1));
        res = Math.max(res, solve(i+1, j));

        return dp[i][j] = res;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.dp = new int[nums1.length][nums2.length];
        for(int[] d : this.dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return solve(0, 0);
    }
}