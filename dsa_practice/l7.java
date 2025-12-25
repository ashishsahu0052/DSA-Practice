class Solution {
    public int reverse(int x) {
        String xStr = String.valueOf(x);
        char[] xChar = xStr.toCharArray();

        int start = xChar[0] == '-' ? 1 : 0;
        int last = xChar.length - 1;

        while (last > start) {
            char temp = xChar[start];
            xChar[start] = xChar[last];
            xChar[last] = temp;
            last--;
            start++;
        }

        try {
            return Integer.parseInt(new String(xChar));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}