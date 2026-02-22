class Solution {
    public int binaryGap(int n) {
        int lastIndex = -1;
        int maxDistance = 0;
        int currentIndex = 0;

        while (n > 0) {
            if ((n & 1) == 1) {   // Check if current bit is 1
                if (lastIndex != -1) {
                    maxDistance = Math.max(maxDistance, currentIndex - lastIndex);
                }
                lastIndex = currentIndex;
            }
            currentIndex++;
            n >>= 1;  // Right shift to check next bit
        }

        return maxDistance;
    }
}