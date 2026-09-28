class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int[] i : intervals) {
            if (i[0] >= lastEnd) {
                lastEnd = i[1];
            } else {
                count++;
            }
        }
        return count;
    }
}