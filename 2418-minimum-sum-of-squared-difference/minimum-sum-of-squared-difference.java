class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long totalDiffSum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiffSum += diff[i];
        }

        long k = k1 + k2;
        if (totalDiffSum <= k) {
            return 0;
        }
        int[] count = new int[100001];
        int maxDiff = 0;
        for (int d : diff) {
            count[d]++;
            maxDiff = Math.max(maxDiff, d);
        }
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (count[i] > 0) {
                long reduceCount = Math.min(k, count[i]);
                count[i] -= reduceCount;
                count[i - 1] += reduceCount;
                k -= reduceCount;
            }
        }
        long minSum = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                minSum += (long) count[i] * i * i;
            }
        }
        return minSum;
    }
}