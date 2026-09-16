class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxVal = (1 << maximumBit) - 1;
        int currentXor = 0;

        for (int num : nums) {
            currentXor ^= num;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = currentXor ^ maxVal;
            currentXor ^= nums[n - 1 - i];
        }

        return result;
    }
}