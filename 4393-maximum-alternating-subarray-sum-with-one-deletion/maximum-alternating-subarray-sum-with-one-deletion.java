class Solution {
    public long maxAlternatingSum(int[] A) {
        long inf = 10000000;
        long a0 = -inf, a1 = -inf, b0 = -inf, b1 = -inf, res = -inf;
        for (int a : A) {
            long nb0 = Math.max(a0, b1 + a);
            b1 = Math.max(a1, b0 - a);
            b0 = nb0;
            long na0 = Math.max(a1 + a, a);
            a1 = a0 - a;
            a0 = na0;
            res = Math.max(res, Math.max(Math.max(a0, a1), Math.max(b0, b1)));
        }
        return res;
    }
}