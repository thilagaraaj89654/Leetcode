class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int ans = 0;
        int i = 0;

        while (i < n) {
            if (i + k <= n && isPalindrome(s, i, i + k - 1)) {
                ans++;
                i += k;
            } 
            else if (i + k + 1 <= n && isPalindrome(s, i, i + k)) {
                ans++;
                i += k + 1;
            } 
            else {
                i++;
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}