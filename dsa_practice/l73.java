class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Set<Integer> setR = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    setR.add(i);
                    setC.add(j);
                }
            }
        }

        for (int r : setR) {
            for (int k = 0; k < col; k++) {
                matrix[r][k] = 0;
            }
        }
        for (int c : setC) {
            for (int k = 0; k < row; k++) {
                matrix[k][c] = 0;
            }
        }

    }
}