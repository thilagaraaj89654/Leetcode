class Solution {
    private static final int MOD = 1000000007;
    long[] sumSq;
    long[] sumC;
    long[] lazy;
    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }
    private void apply(int node, int l, int r, long val) {
        int len = r - l + 1;
        sumSq[node] = (sumSq[node] + 2 * val * sumC[node] + val * val * len) % MOD;
        sumC[node] = (sumC[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }
    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        sumC[node] = (sumC[2 * node] + sumC[2 * node + 1]) % MOD;
    }
    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sumC = new long[4 * n];
        lazy = new long[4 * n];
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;
        long currentTotalSumSq = 0;
        for (int i = 0; i < n; i++) {
            int prev = lastSeen.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, prev + 1, i, 1);
            lastSeen.put(nums[i], i);
            currentTotalSumSq = sumSq[1];
            totalSum = (totalSum + currentTotalSumSq) % MOD;
        }

        return (int) totalSum;
    }
}