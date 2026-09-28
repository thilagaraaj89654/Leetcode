class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int totalTime = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            totalTime += duration;
            maxHeap.offer(duration);

            if (totalTime > lastDay) {
                totalTime -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}