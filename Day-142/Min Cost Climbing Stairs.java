class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        return Math.min(helper(cost, 0, dp), helper(cost, 1, dp));
    }

    private int helper(int[] cost, int i, int[] dp) {
        if(i >= cost.length) return 0;
        if(dp[i] != 0) return dp[i];

        int oneStep = cost[i] + helper(cost, i + 1, dp);
        int twoStep = cost[i] + helper(cost, i + 2, dp);

        return dp[i] = Math.min(oneStep, twoStep);
    }
}