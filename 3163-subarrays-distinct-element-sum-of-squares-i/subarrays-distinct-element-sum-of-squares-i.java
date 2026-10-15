class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                distinctSet.add(nums.get(j));
                int count = distinctSet.size();
                totalSum += count * count;
            }
        }
        return totalSum;
    }
}