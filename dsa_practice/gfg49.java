public class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        // Correct k
        if ((n & (n - 1)) == 0) {
            k /= 2;
        } else {
            k *= 2;
        }

        if (k >= n) return "-1";

        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {
            while (k > 0 && st.length() > 0 &&
                   st.charAt(st.length() - 1) > c) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }
            st.append(c);
        }

        while (k > 0 && st.length() > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }

        return st.length() == 0 ? "-1" : st.toString();
    }
}{

}
