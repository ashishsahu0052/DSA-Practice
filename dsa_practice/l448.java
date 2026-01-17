class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int []arr = new int[n +1];
        arr[0]= -1;
        List <Integer> list = new ArrayList<>();

        for(int i : nums){
            arr[i] = -1;
        }

        for(int i = 1 ; i < n+1; i++){
            if(arr[i] >= 0){
                list.add(i);
            }
        }
        return list;
       
        
    }
}