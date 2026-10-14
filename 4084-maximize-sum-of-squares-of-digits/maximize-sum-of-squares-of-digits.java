class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || sum > 9 * num) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int remainingSlots = num - 1 - i;
            for (int d = 9; d >= 0; d--) {
                if (sum - d >= 0 && sum - d <= 9 * remainingSlots) {
                    sb.append(d);
                    sum -= d;
                    break;
                }
            }
        }
        return sb.toString();
    }
}