class Solution {
    public int trap(int[] height) {
        int len = height.length;

        int[] left = new int[len];
        int[] right = new int[len];

        // checking for biggest block in left 
        int bigInLeft = 0 ; 
        for(int i = 0 ; i< len ;i++){
            bigInLeft = Math.max(bigInLeft , height[i]);
            left[i] = bigInLeft;
        }
        int bigInRight = 0 ; 
        for(int i = len-1 ; i >= 0 ;i--){
            bigInRight = Math.max(bigInRight , height[i]);
            right[i] = bigInRight;
        }

        // formula - min(left , right ) -  height[i]

        int area = 0;

        for(int i = 0 ; i< len ; i++){
            area = area + Math.min(left[i] , right[i]) - height[i];
        }
        return area;
    }
}