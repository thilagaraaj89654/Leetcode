class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (isSorted(s)) {
            return 0;
        }
        if (n <= 2) {
            return -1;
        }

        char minChar = s.charAt(0);
        char maxChar = s.charAt(0);
        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }

        // Check if min is at the start (excluding whole string condition which is handled) 
        // or max is at the end
        boolean minAtStart = (s.charAt(0) == minChar);
        boolean maxAtEnd = (s.charAt(n - 1) == maxChar);

        if (minAtStart || maxAtEnd) {
            return 1;
        }

        // Check for edge case requiring 3 operations (max at start and min at end)
        if (s.charAt(0) == maxChar && s.charAt(n - 1) == minChar) {
            // Check if max appears anywhere else or min appears anywhere else
            boolean multipleMax = false, multipleMin = false;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == maxChar && i != 0) multipleMax = true;
                if (s.charAt(i) == minChar && i != n - 1) multipleMin = true;
            }
            if (!multipleMax && !multipleMin) {
                return 3;
            }
        }

        return 2;
    }

    private boolean isSorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) return false;
        }
        return true;
    }
}