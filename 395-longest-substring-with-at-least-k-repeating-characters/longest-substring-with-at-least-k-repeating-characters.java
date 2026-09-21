class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int next = i + 1;
                while (next < end && count[s.charAt(next) - 'a'] < k) {
                    next++;
                }
                return Math.max(helper(s, start, i, k), helper(s, next, end, k));
            }
        }

        return end - start;
    }
}