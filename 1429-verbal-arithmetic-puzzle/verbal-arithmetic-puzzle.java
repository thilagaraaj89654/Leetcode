class Solution {
    private final int[] POW10 = {1, 10, 100, 1000, 10000, 100000, 1000000};

    public boolean isSolvable(String[] words, String result) {
        Set<Character> charSet = new HashSet<>();
        boolean[] nonZero = new boolean[26];

        for (String word : words) {
            if (word.length() > result.length()) return false;
            if (word.length() > 1) nonZero[word.charAt(0) - 'A'] = true;
            for (char c : word.toCharArray()) charSet.add(c);
        }

        if (result.length() > 1) nonZero[result.charAt(0) - 'A'] = true;
        for (char c : result.toCharArray()) charSet.add(c);

        if (charSet.size() > 10) return false;

        List<Character> charList = new ArrayList<>(charSet);
        int[] charWeights = new int[charList.size()];
        boolean[] charNonZero = new boolean[charList.size()];

        for (int i = 0; i < charList.size(); i++) {
            char c = charList.get(i);
            charNonZero[i] = nonZero[c - 'A'];
            int weight = 0;
            for (String word : words) {
                int pos = word.indexOf(c);
                while (pos != -1) {
                    weight += POW10[word.length() - 1 - pos];
                    pos = word.indexOf(c, pos + 1);
                }
            }
            int pos = result.indexOf(c);
            while (pos != -1) {
                weight -= POW10[result.length() - 1 - pos];
                pos = result.indexOf(c, pos + 1);
            }
            charWeights[i] = weight;
        }

        return backtrack(0, 0, new boolean[10], charWeights, charNonZero);
    }

    private boolean backtrack(int index, int currentSum, boolean[] used, int[] weights, boolean[] nonZero) {
        if (index == weights.length) return currentSum == 0;

        for (int d = 0; d <= 9; d++) {
            if (used[d] || (d == 0 && nonZero[index])) continue;

            used[d] = true;
            if (backtrack(index + 1, currentSum + d * weights[index], used, weights, nonZero)) return true;
            used[d] = false;
        }

        return false;
    }
}