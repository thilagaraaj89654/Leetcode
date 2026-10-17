class Solution {
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[][] items = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = nums[i]; 
            items[i][1] = i;       
        }
        Arrays.sort(items, (a, b) -> {
            int sumA = getDigitSum(a[0]);
            int sumB = getDigitSum(b[0]);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a[0], b[0]);
        });
        boolean[] visited = new boolean[n];
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || items[i][1] == i) {
                continue;
            }
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = items[curr][1];
                cycleSize++;
            }
            if (cycleSize > 1) {
                cycles += (cycleSize - 1);
            }
        }
        return cycles;
    }
}