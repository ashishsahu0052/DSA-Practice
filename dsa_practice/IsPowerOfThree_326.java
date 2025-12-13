public class Main {

    // LeetCode-style Solution class
    static class Solution {
        public boolean isPowerOfThree(int n) {
            if (n == 1) {
                return true;
            }
            if (n <= 0 || n % 3 != 0) {
                return false;
            } else {
                return isPowerOfThree(n / 3);
            }
        }
    }

    // Main function to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 27;  // you can change this value
        boolean result = sol.isPowerOfThree(n);

        System.out.println(n + " is power of three? " + result);
    }
}
