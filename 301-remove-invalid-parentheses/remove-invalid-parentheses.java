class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }

        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, 0, left, right, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int open, int close, int leftRem, int rightRem, StringBuilder current, Set<String> result) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && open == close) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = current.length();

        if (c == '(' && leftRem > 0) {
            backtrack(s, index + 1, open, close, leftRem - 1, rightRem, current, result);
        }
        if (c == ')' && rightRem > 0) {
            backtrack(s, index + 1, open, close, leftRem, rightRem - 1, current, result);
        }

        current.append(c);
        if (c != '(' && c != ')') {
            backtrack(s, index + 1, open, close, leftRem, rightRem, current, result);
        } else if (c == '(') {
            backtrack(s, index + 1, open + 1, close, leftRem, rightRem, current, result);
        } else if (c == ')' && open > close) {
            backtrack(s, index + 1, open, close + 1, leftRem, rightRem, current, result);
        }
        current.setLength(len);
    }
}