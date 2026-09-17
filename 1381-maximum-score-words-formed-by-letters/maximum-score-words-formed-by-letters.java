class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        return backtrack(words, count, score, 0);
    }

    private int backtrack(String[] words, int[] count, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        int max = backtrack(words, count, score, index + 1);
        int wordScore = 0;
        boolean isValid = true;
        int[] currentCount = count.clone();
        for (char c : words[index].toCharArray()) {
            int idx = c - 'a';
            currentCount[idx]--;
            wordScore += score[idx];
            if (currentCount[idx] < 0) {
                isValid = false;
            }
        }
        if (isValid) {
            max = Math.max(max, wordScore + backtrack(words, currentCount, score, index + 1));
        }
        return max;
    }
}