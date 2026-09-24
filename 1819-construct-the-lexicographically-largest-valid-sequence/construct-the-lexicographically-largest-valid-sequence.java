class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        backtrack(0, res, used, n);
        return res;
    }

    private boolean backtrack(int index, int[] res, boolean[] used, int n) {
        while (index < res.length && res[index] != 0) {
            index++;
        }
        if (index == res.length) return true;

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            if (num == 1) {
                res[index] = 1;
                used[1] = true;
                if (backtrack(index + 1, res, used, n)) return true;
                res[index] = 0;
                used[1] = false;
            } else {
                if (index + num < res.length && res[index + num] == 0) {
                    res[index] = num;
                    res[index + num] = num;
                    used[num] = true;

                    if (backtrack(index + 1, res, used, n)) return true;

                    res[index] = 0;
                    res[index + num] = 0;
                    used[num] = false;
                }
            }
        }

        return false;
    }
}