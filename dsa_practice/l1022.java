class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null)
            return 0;

        // Form the binary number
        current = (current << 1) | node.val;

        // If leaf node, return the value
        if (node.left == null && node.right == null) {
            return current;
        }

        // Recurse left and right
        return dfs(node.left, current) + dfs(node.right, current);
    }
}