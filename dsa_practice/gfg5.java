public

import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        int MOD = 1000000007;
        int[] ways = new int[V];
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0}); // {node, distance}
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];
            
            if (d > dist[node]) continue;
            
            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                long newDist = d + nei[1];
                
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{next, newDist});
                } 
                else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[V - 1];
    }
}
