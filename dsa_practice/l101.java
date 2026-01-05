/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        // TreeNode mirror = Mirror(root.left);

        return compare(root.right, root.left);

    }

    public static TreeNode Mirror(TreeNode p) {
        if (p == null)
            return null;
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        Mirror(p.left);
        Mirror(p.right);
        return p;
    }

    public boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;
        return compare(p.left, q.left) && compare(p.right, q.right);

    }
}