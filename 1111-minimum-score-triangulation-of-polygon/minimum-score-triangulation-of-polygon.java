class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int minScore = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int score = values[i] * values[k] * values[j] + dp[i][k] + dp[k][j];
                    minScore = Math.min(minScore, score);
                }
                dp[i][j] = minScore;
            }
        }
        return dp[0][n - 1];
    }
}