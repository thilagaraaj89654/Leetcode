class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int maxGood = 0;
        int totalCombinations = 1 << n;
        for (int mask = 0; mask < totalCombinations; mask++) {
            if (isValid(mask, statements, n)) {
                maxGood = Math.max(maxGood, Integer.bitCount(mask));
            }
        }
        return maxGood;
    }

    private boolean isValid(int mask, int[][] statements, int n) {
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 1) {
                for (int j = 0; j < n; j++) {
                    int st = statements[i][j];
                    if (st != 2) {
                        int actualRole = (mask >> j) & 1;
                        if (st != actualRole) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}