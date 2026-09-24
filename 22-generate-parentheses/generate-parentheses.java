class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }
    private void backtrack(int n, int openb, int closeb, StringBuilder current, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        if (openb < n) {
            current.append('(');
            backtrack(n, openb + 1, closeb, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (closeb < openb) {
            current.append(')');
            backtrack(n, openb, closeb + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}