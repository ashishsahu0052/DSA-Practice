class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int l = timeSeries.length;
        if (l == 0)
            return 0;

        int total = duration;
        for (int i = 1; i < l; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            total = total + Math.min(diff, duration);

        }
        return total;
    }
}