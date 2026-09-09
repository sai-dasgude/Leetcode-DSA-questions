class Solution {

    private int[] dp;
    private int[] cost;

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;

        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n);
    }

    private int solve(int index) {
        if (index <= 1) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int oneStep = solve(index - 1) + cost[index - 1];
        int twoSteps = solve(index - 2) + cost[index - 2];

        return dp[index] = Math.min(oneStep, twoSteps);
    }
}