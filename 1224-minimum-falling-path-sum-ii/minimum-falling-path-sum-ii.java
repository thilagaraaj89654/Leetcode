class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int firstMin = 0;
        int secondMin = 0;
        int firstIdx = -1;

        for (int[] row : grid) {
            int curFirstMin = Integer.MAX_VALUE;
            int curSecondMin = Integer.MAX_VALUE;
            int curFirstIdx = -1;

            for (int j = 0; j < n; j++) {
                int prevVal = (j == firstIdx) ? secondMin : firstMin;
                int sum = row[j] + prevVal;

                if (sum < curFirstMin) {
                    curSecondMin = curFirstMin;
                    curFirstMin = sum;
                    curFirstIdx = j;
                } else if (sum < curSecondMin) {
                    curSecondMin = sum;
                }
            }

            firstMin = curFirstMin;
            secondMin = curSecondMin;
            firstIdx = curFirstIdx;
        }

        return firstMin;
    }
}