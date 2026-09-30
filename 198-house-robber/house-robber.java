class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int rob1 = 0;
        int rob2 = 0;
        for (int i : nums) {
            int robMoney = Math.max(rob1, rob2 + i);
            rob2 = rob1;
            rob1 = robMoney;
        }
        return rob1;
    }
}