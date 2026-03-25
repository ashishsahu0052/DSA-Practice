import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        // Build graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Find initial leaves
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() == 1) {
                queue.offer(i);
            }
        }
        
        int remainingNodes = V;
        
        // Trim leaves layer by layer
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    
                    if (graph.get(neighbor).size() == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        // Remaining nodes are centroids (answers)
        result.addAll(queue);
        return result;
    }
}