class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        java.util.Arrays.sort(arr2);
        int count = 0;

        for (int x : arr1) {
            if (isValid(arr2, x, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int[] arr2, int val, int d) {
        int low = 0, high = arr2.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (Math.abs(arr2[mid] - val) <= d) {
                return false; // Found a close element within distance d
            }
            if (arr2[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return true; // No element in arr2 is within distance d
    }
}