import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
       Map<Integer , Integer> map = new HashMap<>();

       for(int i : nums){
        if(map.containsKey(i)){
            map.replace(i , map.get(i)+1);
        }else{
            map.put(i,1);
        }
       }

       for(int i : nums){
         if(map.get(i) > 1){
            return true;
         }
       }
       return false;
    }
} {
    
}
