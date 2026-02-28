class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] grid = new int[rows][cols];
        for(int i =0; i < cols ; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }else{
                grid[0][i] = 1;
            }


        }
         for(int i = 0; i < rows ; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                grid[i][0] = 1;
            }


        }
        for(int i = 1 ; i < rows ; i++){
            for(int j = 1 ; j < cols ; j++){
              
              if(obstacleGrid[i][j] == 1){
                grid[i][j] = 0;
              }else{
                grid[i][j] = grid[i-1][j]  + grid[i][j-1];
              }
            }
        }
        return grid[rows-1][cols-1];
    }
}