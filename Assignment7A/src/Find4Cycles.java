import java.util.*;

public class Find4Cycles {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 1, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 0, 0, 1}
        };
        findAll4Cycles(graph);
    }

    public static void findAll4Cycles(int[][] graph) {
        int n = graph.length;
        Set<String> cycles = new HashSet<>();

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (graph[a][b] == 0) continue;
                for (int c = 0; c < n; c++) {
                    if (graph[b][c] == 0 || c == a) continue;
                    for (int d = 0; d < n; d++) {
                        if (graph[c][d] == 0 || d == b || d == a) continue;
                        if (graph[d][a] == 1) {

                            // Find a cycle a -> b -> c -> d -> a
                            int[] nodes = new int[]{a, b, c, d};
                            Arrays.sort(nodes);
                            String key = Arrays.toString(nodes);
                            if (!cycles.contains(key)) {
                                cycles.add(key);
                                System.out.println("Cycle: " + a + " -> " + b + " -> " + c + " -> " + d + " -> " + a);
                            }
                        }
                    }
                }
            }
        }

        if (cycles.isEmpty()) {
            System.out.println("No 4-cycles found.");
        }
    }
}
