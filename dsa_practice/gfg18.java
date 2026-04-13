class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        int[] res = num.clone();

        // Step 1: mirror left → right
        for (int i = 0; i < n / 2; i++) {
            res[n - i - 1] = res[i];
        }

        // check if greater
        boolean greater = false;
        for (int i = 0; i < n; i++) {
            if (res[i] > num[i]) {
                greater = true;
                break;
            } else if (res[i] < num[i]) {
                break;
            }
        }

        if (greater)
            return res;

        // Step 2: add 1 to middle
        int carry = 1;
        int mid = n / 2;

        if (n % 2 == 1) {
            res[mid] += carry;
            carry = res[mid] / 10;
            res[mid] %= 10;
            mid--;
        } else {
            mid = mid - 1;
        }

        // propagate carry to left
        while (mid >= 0 && carry > 0) {
            res[mid] += carry;
            carry = res[mid] / 10;
            res[mid] %= 10;
            mid--;
        }

        // if still carry (like 999 → 1001)
        if (carry > 0) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            ans[n] = 1;
            return ans;
        }

        // Step 3: mirror again
        for (int i = 0; i < n / 2; i++) {
            res[n - i - 1] = res[i];
        }

        return res;
    }
}