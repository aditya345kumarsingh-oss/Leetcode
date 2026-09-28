class Solution {
    public boolean canFinish(int V, int[][] edges) {
           List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] inPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, graph, visited, inPath)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] inPath) {
        visited[node] = true;
        inPath[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, graph, visited, inPath)) {
                    return true;
                }
            } else if (inPath[neigh]) {
                return true;
            }
        }

        inPath[node] = false;
        return false;
        
    }
}