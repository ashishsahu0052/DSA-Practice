import java.util.*;

class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= 32; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : arr) {
            buckets.get(Integer.bitCount(num)).add(num);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 32; i >= 0; i--) {
            result.addAll(buckets.get(i));
        }

        return result;
    }
}