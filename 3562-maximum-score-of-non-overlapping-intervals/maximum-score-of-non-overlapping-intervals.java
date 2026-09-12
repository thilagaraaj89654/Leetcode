class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] sorted = new int[n][4];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            sorted[i][0] = interval.get(0);
            sorted[i][1] = interval.get(1);
            sorted[i][2] = interval.get(2);
            sorted[i][3] = i;
        }

        Arrays.sort(sorted, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] path = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                path[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
            int l = 0, r = i - 2, prev = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (sorted[mid][1] < sorted[i - 1][0]) {
                    prev = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int prevIdx = prev + 1;

            for (int k = 1; k <= 4; k++) {
                dp[i][k] = dp[i - 1][k];
                path[i][k] = new ArrayList<>(path[i - 1][k]);

                long takeWeight = dp[prevIdx][k - 1] + sorted[i - 1][2];
                if (takeWeight > dp[i][k]) {
                    dp[i][k] = takeWeight;
                    List<Integer> cand = new ArrayList<>(path[prevIdx][k - 1]);
                    cand.add(sorted[i - 1][3]);
                    Collections.sort(cand);
                    path[i][k] = cand;
                } else if (takeWeight == dp[i][k] && takeWeight > 0) {
                    List<Integer> cand = new ArrayList<>(path[prevIdx][k - 1]);
                    cand.add(sorted[i - 1][3]);
                    Collections.sort(cand);

                    if (path[i][k].isEmpty() || compareLexicographically(cand, path[i][k]) < 0) {
                        dp[i][k] = takeWeight;
                        path[i][k] = cand;
                    }
                }
            }
        }

        int[] result = new int[path[n][4].size()];
        for (int i = 0; i < path[n][4].size(); i++) {
            result[i] = path[n][4].get(i);
        }
        return result;
    }

    private int compareLexicographically(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}