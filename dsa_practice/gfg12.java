import java.util.*;

class Solution {
    class Node {
        int data;      // frequency
        int index;     // original index (for leaf) or min index in subtree (for internal)
        Node left;
        Node right;
        
        Node(int data, int index) {
            this.data = data;
            this.index = index;
            this.left = null;
            this.right = null;
        }
        
        Node(int data, int index, Node left, Node right) {
            this.data = data;
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }
    
    // Preorder traversal to collect Huffman codes
    private void preOrder(Node root, ArrayList<String> ans, String curr) {
        if (root == null) return;
        
        // Leaf node (has no children)
        if (root.left == null && root.right == null) {
            // Handle single character case
            if (curr.equals("")) curr = "0";
            ans.add(curr);
            return;
        }
        
        preOrder(root.left, ans, curr + '0');
        preOrder(root.right, ans, curr + '1');
    }
    
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        int n = s.length();
        
        // Min heap simulation using PriorityQueue
        // Each element: [frequency, index, node]
        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> {
            int freqCompare = Integer.compare((int)a[0], (int)b[0]);
            if (freqCompare != 0) return freqCompare;
            return Integer.compare((int)a[1], (int)b[1]);
        });
        
        // Create leaf nodes
        for (int i = 0; i < n; i++) {
            Node node = new Node(f[i], i);
            pq.offer(new Object[]{f[i], i, node});
        }
        
        // Single character case
        if (n == 1) {
            ArrayList<String> result = new ArrayList<>();
            result.add("0");
            return result;
        }
        
        // Construct Huffman tree
        while (pq.size() > 1) {
            Object[] left = pq.poll();
            Object[] right = pq.poll();
            
            int leftFreq = (int)left[0];
            int leftIndex = (int)left[1];
            Node leftNode = (Node)left[2];
            
            int rightFreq = (int)right[0];
            int rightIndex = (int)right[1];
            Node rightNode = (Node)right[2];
            
            // Create new internal node
            // Index = minimum of left and right indices (for tie-breaking)
            int newIndex = Math.min(leftIndex, rightIndex);
            int newFreq = leftFreq + rightFreq;
            Node newNode = new Node(newFreq, newIndex, leftNode, rightNode);
            
            pq.offer(new Object[]{newFreq, newIndex, newNode});
        }
        
        Node root = (Node)pq.poll()[2];
        
        ArrayList<String> ans = new ArrayList<>();
        preOrder(root, ans, "");
        
        return ans;
    }
}