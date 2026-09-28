class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }
        int maxFreqCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxFreqCount++;
            }
        }
        int emptySlots = (maxFreq - 1) * (n - (maxFreqCount - 1));
        int remainingTasks = tasks.length - maxFreq * maxFreqCount;
        int idles = Math.max(0, emptySlots - remainingTasks);
        return tasks.length + idles;
    }
}