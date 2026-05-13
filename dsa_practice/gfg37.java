import java.util.*;

class Solution {

    public int findMotherVertex(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[V];

        int candidate = 0;

        // find candidate mother vertex
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(i, adj, visited);
                candidate = i;
            }
        }

        // verify candidate
        Arrays.fill(visited, false);

        dfs(candidate, adj, visited);

        for (boolean v : visited) {
            if (!v) return -1;
        }

        return candidate;
    }

    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited) {

        visited[node] = true;

        for (int nei : adj.get(node)) {

            if (!visited[nei]) {
                dfs(nei, adj, visited);
            }
        }
    }
}