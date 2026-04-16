import javax.swing.tree.TreeNode;

public /**
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return null;

        TreeNode temp = root ; 
        TreeNode q = null;
        while(temp != null){
            q = temp ; 
            if(val < root.val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }

        if(val < q.val){
            q.left = new TreeNode(val);
        }else{
            q.right = new TreeNode(val);
        }
        return root;
    }
} {
    
}
