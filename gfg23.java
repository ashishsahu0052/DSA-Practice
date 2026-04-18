class Solution {
    int maxOnes(int[] arr) {
        int ones = 0;

        // count initial ones
        for (int num : arr) {
            if (num == 1)
                ones++;
        }

        int maxGain = 0, curr = 0;

        for (int num : arr) {
            int val = (num == 0) ? 1 : -1;

            curr = Math.max(val, curr + val);
            maxGain = Math.max(maxGain, curr);
        }

        return ones + maxGain;
    }
}