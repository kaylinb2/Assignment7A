import java.util.*;

public class WeaklyConnected {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };
        System.out.println("Is weakly connected? " + isWeakleyConnected(matrix));
    }

    public static boolean isWeakleyConnected(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>> undirectedGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) undirectedGraph.add(new ArrayList<>());

        // Convert Undirected Graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 1 || matrix[j][i] == 1) {
                    undirectedGraph.get(i).add(j);
                    undirectedGraph.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        dfs(undirectedGraph, 0, visited);

        for (boolean v : visited)
            if (!v) return false;

        return true;

    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}