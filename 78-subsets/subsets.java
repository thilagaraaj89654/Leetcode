class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());
        for(int i:nums) {
            int size = allSubsets.size();
            for(int j = 0; j < size; j++) {
                List<Integer> subSet = new ArrayList<>(allSubsets.get(j));
                subSet.add(i);
                allSubsets.add(subSet);
            }
        }
        return allSubsets;
    }

}