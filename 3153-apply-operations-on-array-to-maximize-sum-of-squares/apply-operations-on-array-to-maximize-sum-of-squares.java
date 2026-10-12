class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[30];
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        long[] reconstructed = new long[nums.size()];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < bitCount[i]; j++) {
                reconstructed[j] |= (1L << i);
            }
        }
        long mod = 1_000_000_007;
        long maxSum = 0;

        for (int i = 0; i < k; i++) {
            long val = reconstructed[i] % mod;
            maxSum = (maxSum + (val * val) % mod) % mod;
        }
        return (int) maxSum;
    }
}