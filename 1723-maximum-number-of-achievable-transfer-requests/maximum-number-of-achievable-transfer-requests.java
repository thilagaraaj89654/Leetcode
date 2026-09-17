class Solution {
    private int maxRequests = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] netChange = new int[n];
        backtrack(requests, 0, 0, netChange);
        return maxRequests;
    }

    private void backtrack(int[][] requests, int index, int count, int[] netChange) {
        if (index == requests.length) {
            for (int val : netChange) {
                if (val != 0) return;
            }
            maxRequests = Math.max(maxRequests, count);
            return;
        }
        backtrack(requests, index + 1, count, netChange);
        int from = requests[index][0];
        int to = requests[index][1];
        netChange[from]--;
        netChange[to]++;

        backtrack(requests, index + 1, count + 1, netChange);
        netChange[from]++;
        netChange[to]--;
    }
}