class Solution {

    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n))
            return -1;

        if (d % gcd(m, n) != 0)
            return -1;

        return Math.min(solve(m, n, d), solve(n, m, d));
    }

    int solve(int fromCap, int toCap, int d) {
        int from = 0, to = 0;
        int steps = 0;

        while (from != d && to != d) {

            if (from == 0) {
                from = fromCap;
                steps++;
            }

            else if (to == toCap) {
                to = 0;
                steps++;
            }

            else {
                int transfer = Math.min(from, toCap - to);
                to += transfer;
                from -= transfer;
                steps++;
            }
        }

        return steps;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}