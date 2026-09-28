import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, inPath, order)) {
                    return new int[0];
                }
            }
        }

       
        Collections.reverse(order);

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] inPath, List<Integer> order) {
        visited[node] = true;
        inPath[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, graph, visited, inPath, order)) {
                    return true; 
                }
            } else if (inPath[neigh]) {
                return true; 
            }
        }

        inPath[node] = false;
        order.add(node);
        return false;
    }
}