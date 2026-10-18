class Solution {
    private static final int MOD = 1000000007;
    private long[][] combinatorics;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        combinatorics = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            combinatorics[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                combinatorics[i][j] = (combinatorics[i - 1][j - 1] + combinatorics[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) (countWays(list) - 1 + MOD) % MOD;
    }

    private long countWays(List<Integer> nums) {
        int n = nums.size();
        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> leftTree = new ArrayList<>();
        List<Integer> rightTree = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                leftTree.add(nums.get(i));
            } else {
                rightTree.add(nums.get(i));
            }
        }

        long leftWays = countWays(leftTree);
        long rightWays = countWays(rightTree);

        long ways = combinatorics[leftTree.size() + rightTree.size()][leftTree.size()];
        ways = (ways * leftWays) % MOD;
        ways = (ways * rightWays) % MOD;

        return ways;
    }
}