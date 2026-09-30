class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int prev2 = 0;
        int prev1 = 0;

        for (int point : points) {
            int temp = Math.max(prev1, prev2 + point);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}