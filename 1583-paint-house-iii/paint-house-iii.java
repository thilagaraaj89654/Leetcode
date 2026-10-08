class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        final int INF = 1_000_000_000;
        int[][][] dp = new int[m][n + 1][target + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        if (houses[0] != 0) {
            dp[0][houses[0]][1] = 0;
        } else {
            for (int color = 1; color <= n; color++) {
                dp[0][color][1] = cost[0][color - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            int curColor = houses[i];
            for (int color = 1; color <= n; color++) {
                if (curColor != 0 && color != curColor) continue;
                int paintCost = (curColor != 0) ? 0 : cost[i][color - 1];
                for (int k = 1; k <= target; k++) {
                    for (int prevColor = 1; prevColor <= n; prevColor++) {
                        int prevK = (prevColor == color) ? k : k - 1;
                        if (prevK >= 1 && dp[i - 1][prevColor][prevK] != INF) {
                            dp[i][color][k] = Math.min(dp[i][color][k], dp[i - 1][prevColor][prevK] + paintCost);
                        }
                    }
                }
            }
        }
        int minCost = INF;
        for (int color = 1; color <= n; color++) {
            minCost = Math.min(minCost, dp[m - 1][color][target]);
        }
        return minCost == INF ? -1 : minCost;
    }
}