class Solution {
    public char findTheDifference(String s, String t) {
        int x = 0; 

        for(char c: s.toCharArray()){
            x = x ^ c; 

        }
        int y = 0; 

        for(char c: t.toCharArray()){
            y = y ^ c; 
            
        }

        return (char) (x^y);
    }
}