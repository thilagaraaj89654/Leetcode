class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex;
            }
            endIndex = allSubsets.size();
            for (int j = startIndex; j < endIndex; j++) {
                List<Integer> subSet = new ArrayList<>(allSubsets.get(j));
                subSet.add(nums[i]);
                allSubsets.add(subSet);
            }
        }
        return allSubsets;
    }
}