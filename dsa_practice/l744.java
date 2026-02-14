class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        char ans = letters[0]; // handles wrap around

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (letters[mid] > target) {
                ans = letters[mid]; // update candidate
                end = mid - 1; // search smaller greater letter
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
