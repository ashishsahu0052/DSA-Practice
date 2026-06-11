class Solution {
    public int findIndex(String s) {
        int n = s.length();

        int[] suffixClose = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixClose[i] = suffixClose[i + 1];
            if (s.charAt(i) == ')') {
                suffixClose[i]++;
            }
        }

        int openBefore = 0;

        for (int i = 0; i <= n; i++) {
            if (openBefore == suffixClose[i]) {
                return i;
            }

            if (i < n && s.charAt(i) == '(') {
                openBefore++;
            }
        }

        return -1;
    }
}