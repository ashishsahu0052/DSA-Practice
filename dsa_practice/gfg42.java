class Solution {
    public int coin(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (right - left > 0) {

            // Player 1 move
            if (arr[left] >= arr[right]) {
                left++;
            } else {
                right--;
            }

            // If one coin remains
            if (left == right)
                break;

            // Player 2 move
            if (arr[left] >= arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return arr[left];
    }
}