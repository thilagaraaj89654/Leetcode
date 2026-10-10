class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k + 1];
        int moves = 0;
        while (dp[k] < n) {
            moves++;
            for (int i = k; i >= 1; i--) {
                dp[i] = 1 + dp[i] + dp[i - 1];
            }
        }
        return moves;
    }
}