class Solution {
    private int maxLen = 0;

    public int maxLength(List<String> arr) {
        List<Integer> validMasks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            boolean isUnique = true;
            for (char c : s.toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((mask & bit) != 0) {
                    isUnique = false;
                    break;
                }
                mask |= bit;
            }
            if (isUnique) {
                validMasks.add(mask);
            }
        }

        backtrack(validMasks, 0, 0, 0);
        return maxLen;
    }

    private void backtrack(List<Integer> masks, int index, int currentMask, int currentLength) {
        maxLen = Math.max(maxLen, currentLength);

        for (int i = index; i < masks.size(); i++) {
            int mask = masks.get(i);
            if ((currentMask & mask) == 0) {
                backtrack(masks, i + 1, currentMask | mask, currentLength + Integer.bitCount(mask));
            }
        }
    }
}