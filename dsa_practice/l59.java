class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0; 
        int bottom = n-1;
        int left = 0 ; 
        int right = n-1;
        int[][] matrix = new int[n][n];
        int num =0;
        while(left <= right && top <= bottom){
            //put values left to right
            for(int i = left ; i <= right ; i++){
                matrix[top][i] = ++num;
            }top++;

            // top to bottom fill 

            for(int i = top ; i<= bottom ; i++){
                matrix[i][right] = ++num;
            }right--;


            if(left <= right){
                for(int i = right ;i >= left ; i--){
                    matrix[bottom][i] = ++num;
                }
                bottom--;
            }

            if(top <= bottom ){
                for(int i = bottom ; i >= top ; i--){
                    matrix[i][left] = ++num;
                }left++;
            }
        }

        return matrix;
        
    }
}