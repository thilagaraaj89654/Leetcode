class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(robs(nums, 0, n-2), robs(nums, 1, n-1));
    }
    private int robs(int[] nums, int low, int high) {
        int robber1 = 0;
        int robber2 = 0;
        for(int i = low; i <= high; i++) {
            int robbed = Math.max(robber1, robber2 + nums[i]);
            robber2 = robber1;
            robber1 = robbed;
        }
        return robber1;
    }
}