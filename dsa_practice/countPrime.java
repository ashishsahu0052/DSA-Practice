public abstract class countPrime {
    class Solution {

        public int countPrimes(int n) {
            if (n <= 1) {
                return 0;
            }
            int count = 0;
            boolean[] isPrime = new boolean[n];
            for (int i = 2; i < n; i++) {
                isPrime[i] = true;
            }

            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {

                    for (int j = i * i; j < n; j = j + i) {
                        isPrime[j] = false;
                    }
                }
            }
            for (boolean j : isPrime) {
                if (j)
                    count++;
            }
            return count;
        }
    }
}
