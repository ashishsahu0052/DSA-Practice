class Solution {
    int countStrings(int n) {
        long a = 1; // ending with 0
        long b = 1; // ending with 1
        
        for (int i = 2; i <= n; i++) {
            long newA = a + b;
            long newB = a;
            
            a = newA;
            b = newB;
        }
        
        return (int)(a + b);
    }
}