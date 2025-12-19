class Solution {
    public int string.

    java KthLargestElemwnt(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : nums) {
            pq.add(i);
        }
        int ans = 0;
        while (k > 0) {
            ans = pq.poll();
            k--;
        }
        return ans;
    }
}