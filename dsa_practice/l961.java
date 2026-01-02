class Solution {
    public int repeatedNTimes(int[] nums) {
        int length = nums.length;
        int n = length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {

                map.put(i, 1);
            }

        }

        for (int i : map.keySet()) {
            if (map.get(i) == n) {
                return i;
            }
        }
        return -1;

    }
}