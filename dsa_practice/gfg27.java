class Solution {
    public int smallestSubstring(String s) {
        int[] freq = new int[3]; // for '0','1','2'
        int left = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int right = 0; right < s.length(); right++){
            int idx = s.charAt(right) - '0';
            
            if(freq[idx] == 0) count++; // new char added
            freq[idx]++;
            
            // when all 3 present
            while(count == 3){
                minLen = Math.min(minLen, right - left + 1);
                
                int lidx = s.charAt(left) - '0';
                freq[lidx]--;
                if(freq[lidx] == 0) count--;
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}