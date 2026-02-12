class Solution {
    public int hammingDistance(int x, int y) {

        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            xor &= (xor - 1); // removes lowest set bit
            count++;
        }

        return count;
    }
}
