class Solution {
    public int longestPalindrome(String s) {
        
        int[] freq = new int[128];
        
        for(char ch : s.toCharArray()) {
            freq[ch]++;
        }
        
        int len = 0;
        boolean oddFound = false;
        
        for(int count : freq) {
            
            if(count % 2 == 0) {
                len += count;
            } else {
                len += count - 1;
                oddFound = true;
            }
        }
        
        if(oddFound) len++;
        
        return len;
    }
}