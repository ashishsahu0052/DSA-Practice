class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int r = 0;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;

    }
}

class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int r = 0;
        int count = 0;
        int c = col - 1;

        while (c >= 0 && r < row) {
            if (grid[r][c] < 0) {
                count = count + (row - r);
                c--;
            } else {
                r++;
            }
        }
        return count;

    }
}