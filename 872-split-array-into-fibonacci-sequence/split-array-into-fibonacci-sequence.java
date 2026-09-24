class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, 0, result);
        return result;
    }

    private boolean backtrack(String num, int index, List<Integer> result) {
        if (index == num.length()) {
            return result.size() >= 3;
        }

        long currentNum = 0;
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break;

            currentNum = currentNum * 10 + (num.charAt(i) - '0');
            if (currentNum > Integer.MAX_VALUE) break;

            int size = result.size();
            if (size >= 2) {
                long sum = (long) result.get(size - 1) + result.get(size - 2);
                if (currentNum < sum) continue;
                if (currentNum > sum) break;
            }

            result.add((int) currentNum);
            if (backtrack(num, i + 1, result)) return true;
            result.remove(result.size() - 1);
        }

        return false;
    }
}