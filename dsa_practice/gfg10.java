public class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        
        int hold = -arr[0];  // max profit when holding stock
        int cash = 0;        // max profit when not holding
        
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + arr[i] - k); // sell
            hold = Math.max(hold, cash - arr[i]);     // buy
        }
        
        return cash;
    }
}{

}
