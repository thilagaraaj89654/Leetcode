class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(num, target, 0, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String num, int target, int index, long eval, long multed, StringBuilder path, List<String> result) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        int len = path.length();
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            long cur = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                path.append(cur);
                backtrack(num, target, i + 1, cur, cur, path, result);
                path.setLength(len);
            } else {
                path.append('+').append(cur);
                backtrack(num, target, i + 1, eval + cur, cur, path, result);
                path.setLength(len);

                path.append('-').append(cur);
                backtrack(num, target, i + 1, eval - cur, -cur, path, result);
                path.setLength(len);

                path.append('*').append(cur);
                backtrack(num, target, i + 1, eval - multed + multed * cur, multed * cur, path, result);
                path.setLength(len);
            }
        }
    }
}