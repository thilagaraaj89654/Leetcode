class Solution {
    public int minMoves2(int[] nums) {
        java.util.Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}