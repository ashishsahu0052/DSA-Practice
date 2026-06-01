class Solution {
    public int findMaxProduct(int[] arr) {
        long mod = 1000000007L;

        int n = arr.length;
        if (n == 1) return arr[0];

        int negCount = 0;
        int zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
            } else if (x < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, x);
            }
        }

        // All zeros
        if (zeroCount == n) return 0;

        // One negative and rest zeros
        if (negCount == 1 && negCount + zeroCount == n) {
            return 0;
        }

        long ans = 1;
        boolean skipped = false;
        int used = 0;

        for (int x : arr) {
            if (x == 0) continue;

            if ((negCount & 1) == 1 && x == maxNeg && !skipped) {
                skipped = true;
                continue;
            }

            ans = (ans * ((x % mod + mod) % mod)) % mod;
            used++;
        }

        // Case like [-1]
        if (used == 0) return maxNeg;

        return (int) ans;
    }
}