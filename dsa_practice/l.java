import java.util.*;

class Solution {
    public int countAtMostK(int arr[], int k) {
        int left = 0;
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {

            // Add current element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // Shrink window if distinct count > k
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);

                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Count valid subarrays ending at right
            result += (right - left + 1);
        }

        return result;
    }
}
