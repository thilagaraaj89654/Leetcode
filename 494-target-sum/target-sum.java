class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int x: nums) total += x;
        if(Math.abs(target)>total || (target + total) % 2 != 0) return 0;
        int p = (target + total) / 2;
        int[] dp = new int[p+1];
        dp[0] = 1;
        for(int x : nums) {
            for(int i = p; i >= x; i--) {
                dp[i] += dp[i-x];
           }
       }
       return dp[p];
    }
}