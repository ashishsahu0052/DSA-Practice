class Solution {
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;
        
        int totalSum = 0;
        for(int num : arr) totalSum += num;
        
        // invalid case
        if((totalSum + diff) % 2 != 0) return 0;
        
        int target = (totalSum + diff) / 2;
        
        return countSubsets(arr, target);
    }
    
    int countSubsets(int[] arr, int target){
        int n = arr.length;
        
        int dp[][] = new int[n][target+1];
        
        // base case
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        if(arr[0] != 0 && arr[0] <= target){
            dp[0][arr[0]] = 1;
        }
        
        for(int i=1; i<n; i++){
            for(int sum=0; sum<=target; sum++){
                
                int notTake = dp[i-1][sum];
                int take = 0;
                
                if(arr[i] <= sum){
                    take = dp[i-1][sum - arr[i]];
                }
                
                dp[i][sum] = take + notTake;
            }
        }
        
        return dp[n-1][target];
    }
}