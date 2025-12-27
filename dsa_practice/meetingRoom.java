class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            free.offer(i);

        PriorityQueue<long[]> busy = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));

        int[] count = new int[n];

        for (int[] meet : meetings) {
            long start = meet[0], end = meet[1];

            // Free rooms that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.offer((int) busy.poll()[1]);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                busy.offer(new long[] { end, room });
                count[room]++;
            } else {
                // Delay meeting
                long[] earliest = busy.poll();
                long newEnd = earliest[0] + (end - start);
                busy.offer(new long[] { newEnd, earliest[1] });
                count[(int) earliest[1]]++;
            }
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}
