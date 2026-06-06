class Solution {
    public int numOfWays(int n, int m) {
        long squares = 1L * n * m;

        long totalWays = squares * (squares - 1);

        long attackingWays = 4L * (
                (long)(n - 1) * (m - 2)
              + (long)(n - 2) * (m - 1)
        );

        return (int)(totalWays - attackingWays);
    }
}