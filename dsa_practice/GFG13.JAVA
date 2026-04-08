class Solution {
    void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            if(arr[left] == 0){
                left++;
            } else {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            }
        }
    }
}