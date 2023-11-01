class Solution {
  public int minCostClimbingStairs(int[] cost) {
    // Iterate through the cost array in reverse order starting from the third-to-last element.
    for (var i = cost.length-3; i >= 0; i--)
      // Update the cost of the current step by adding the minimum cost of either advancing one or two steps.
      cost[i] += Math.min(cost[i+1], cost[i+2]);

    // Return the minimum cost of reaching the top from either the first or second step.
    return Math.min(cost[0], cost[1]);
  }
}