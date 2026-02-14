class Solution {
    static boolean canPaint(int[] arr, int k, int maxTime) {

        int painters = 1;
        int currSum = 0;

        for (int length : arr) {

            if (currSum + length <= maxTime) {
                currSum += length;
            } else {
                painters++;
                currSum = length;

                if (painters > k) return false;
            }
        }

        return true;
    }

    static int minTime(int[] arr, int k) {

        int low = 0, high = 0;

        for (int length : arr) {
            low = Math.max(low, length);
            high += length;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
