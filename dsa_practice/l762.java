class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        // Possible prime counts (max set bits <= 20)
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        
        int count = 0;
        
        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);  // counts 1s
            
            if (isPrime(setBits, primes)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(int num, int[] primes) {
        for (int p : primes) {
            if (p == num) return true;
        }
        return false;
    }
}