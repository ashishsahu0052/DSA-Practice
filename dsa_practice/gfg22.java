class Solution {
    boolean canFormPalindrome(String s) {
        int[] freq = new int[256];
        
        for(char ch : s.toCharArray()){
            freq[ch]++;
        }
        
        int oddCount = 0;
        
        for(int count : freq){
            if(count % 2 != 0){
                oddCount++;
            }
        }
        
        return oddCount <= 1;
    }
}