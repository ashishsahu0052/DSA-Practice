class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int num : arr){
            
            while(!stack.isEmpty() && 
                  ((stack.peek() > 0 && num < 0) || 
                   (stack.peek() < 0 && num > 0))){
                
                int top = stack.peek();
                
                if(Math.abs(top) > Math.abs(num)){
                    num = 0; // current destroyed
                    break;
                }
                else if(Math.abs(top) < Math.abs(num)){
                    stack.pop(); // top destroyed
                    // continue checking (chain)
                }
                else{
                    stack.pop(); // both destroyed
                    num = 0;
                    break;
                }
            }
            
            if(num != 0){
                stack.push(num);
            }
        }

        return new ArrayList<>(stack);
    }
}