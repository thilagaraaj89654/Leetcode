class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i];
            int t = time[i];
            for (int j = n; j >= 0; j--) {
                int wallsCovered = Math.min(n, j + 1 + t);
                dp[wallsCovered] = Math.min(dp[wallsCovered], dp[j] + c);
            }
        }
        return dp[n];
    }
}