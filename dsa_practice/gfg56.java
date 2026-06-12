class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();

        if (n % k != 0)
            return false;

        HashMap<String, Integer> map = new HashMap<>();
        int blocks = n / k;
        int maxFreq = 0;

        for (int i = 0; i < n; i += k) {
            String sub = s.substring(i, i + k);
            int freq = map.getOrDefault(sub, 0) + 1;
            map.put(sub, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        return maxFreq >= blocks - 1;
    }
}