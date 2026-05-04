class Solution {
    public boolean isBinaryPalindrome(int n) {
        int left = 31;
        int right = 0;

        // find highest set bit
        while (left > right && ((n >> left) & 1) == 0) {
            left--;
        }

        // compare bits
        while (left > right) {
            int l = (n >> left) & 1;
            int r = (n >> right) & 1;

            if (l != r) return false;

            left--;
            right++;
        }

        return true;
    }
}