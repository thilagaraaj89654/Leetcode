class Solution {
    public int jump(int[] nums) {
        int jump = 0, current = 0, canReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            canReach = Math.max(canReach, i + nums[i]);
            if (i == current) {
                jump++;
                current = canReach;
            }
        }
        return jump;
    }
}