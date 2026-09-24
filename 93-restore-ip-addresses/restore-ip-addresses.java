class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return result;
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int dots, StringBuilder current, List<String> result) {
        if (dots == 4) {
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        int len = current.length();
        for (int end = index; end < Math.min(index + 3, s.length()); end++) {
            String part = s.substring(index, end + 1);
            if (isValid(part)) {
                current.append(part).append(".");
                backtrack(s, end + 1, dots + 1, current, result);
                current.setLength(len);
            }
        }
    }

    private boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') return false;
        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
}