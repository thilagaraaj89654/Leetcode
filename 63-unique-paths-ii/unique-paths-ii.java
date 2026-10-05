class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int c = obstacleGrid[0].length;
        int[] dp = new int[c];   
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] row : obstacleGrid) {
            for (int col = 0; col < c; col++) {
                if (row[col] == 1) {
                    dp[col] = 0;
                } else if (col > 0) {
                    dp[col] += dp[col - 1];
                }
            }
        }
        return dp[c - 1];
    }
}