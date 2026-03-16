class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] ar = new boolean[n][m];
        List<Integer> al = new ArrayList<>();

        int dir = 0;
        int i = 0, j =0;
        boolean dirChanged = false;
        while(al.size() < n*m) {
            if(dirChanged == false) {
                ar[i][j] = true;
                al.add(matrix[i][j]);
            }
            if(dir == 0) {
                j++;
                if(j==m || ar[i][j] == true) {
                    j--;
                    dir = (dir + 1) % 4;
                    dirChanged = true;
                } else {
                    dirChanged = false;
                }
            } else if(dir == 1) {
                i++;
                if(i==n || ar[i][j] == true) {
                    i--;
                    dir = (dir + 1) % 4;
                    dirChanged = true;
                } else {
                    dirChanged = false;
                }
            } else if(dir == 2) {
                j--;
                if(j<0 || ar[i][j] == true) {
                    j++;
                    dir = (dir + 1) % 4;
                    dirChanged = true;
                } else {
                    dirChanged = false;
                }
            } else if(dir == 3) {
                i--;
                if(i <0 || ar[i][j] == true) {
                    i++;
                    dir = (dir + 1) % 4;
                    dirChanged = true;
                } else {
                    dirChanged = false;
                }
            }
        }
        return al;
    }
}