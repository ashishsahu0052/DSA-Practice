class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int[] cover = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                int left = Math.max(0, i - x);
                int right = Math.min(n - 1, i + x);

                cover[left]++;
                if (right + 1 < n)
                    cover[right + 1]--;
            }
        }

        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr += cover[i];

            if (curr <= 0)
                return false;
        }

        return true;
    }
}