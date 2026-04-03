/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> bigList = new ArrayList<>();
        // key stores column 
        //pait row , node val
        Map<Integer , List<Pair<Integer , Integer>>> map = new TreeMap<>();
        helper(map  , root , 0 , 0 );
        //sorted if in same level 

        for(int key : map.keySet()){
            List<Pair<Integer , Integer>> list = map.get(key);

            list.sort((a,b) -> a.getKey().compareTo(b.getKey()) == 0
            ?a.getValue().compareTo(b.getValue()):
            a.getKey().compareTo(b.getKey()));

            List<Integer> smallList = new ArrayList<>();

            for(Pair<Integer,Integer> pair : list){
                smallList.add(pair.getValue());
            }
              bigList.add(smallList);
        }

        return bigList; 
    }

    void helper( Map<Integer , List<Pair<Integer , Integer>>> map , TreeNode root, int hd , int level){
            //base case 

            if(root == null) return ;
            
             if(!map.containsKey(hd)){
            map.put(hd, new ArrayList<>());
            }
              map.get(hd).add(new Pair(level, root.val));
             // helper call

             helper(map , root.left , hd-1 , level+1);
             helper(map , root.right , hd+1 , level+1);
    }
}