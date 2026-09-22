class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            if (remaining == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remaining) break;

            current.add(i);
            backtrack(k, remaining - i, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}