class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int c : cost) {
            for (int i = c; i <= target; i++) {
                if (dp[i - c] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - c] + 1);
                }
            }
        }
        if (dp[target] == -1) return "0";
        StringBuilder sb = new StringBuilder();
        int currentCost = target;
        for (int digit = 9; digit >= 1; digit--) {
            int c = cost[digit - 1];
            while (currentCost >= c && dp[currentCost - c] == dp[currentCost] - 1) {
                sb.append(digit);
                currentCost -= c;
            }
        }
        return sb.toString();
    }
}