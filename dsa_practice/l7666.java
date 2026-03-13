class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix[0].length - 1; i++) {
            boolean result = false;
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[j][i] != matrix[j + 1][i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}