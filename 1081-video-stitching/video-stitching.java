class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] maxReach = new int[time + 1];
        for (int[] clip : clips) {
            if (clip[0] < time) {
                maxReach[clip[0]] = Math.max(maxReach[clip[0]], clip[1]);
            }
        }

        int count = 0, currentEnd = 0, nextEnd = 0;
        for (int i = 0; i < time; i++) {
            nextEnd = Math.max(nextEnd, maxReach[i]);
            if (i == currentEnd) {
                if (nextEnd <= i) return -1;
                count++;
                currentEnd = nextEnd;
            }
        }

        return count;
    }
}