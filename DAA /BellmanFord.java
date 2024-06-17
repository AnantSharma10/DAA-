import java.util.Arrays;

public class BellmanFord {

    // Method to find the shortest paths using the Bellman-Ford algorithm
    public static void bellmanFord(int v, int[][] cost, int[] dist, int n) {
        // Initialize the distance array
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[v] = 0;
        
        // Relax edges up to n-1 times
        for (int k = 1; k <= n - 1; k++) {
            for (int u = 1; u <= n; u++) {
                if (u != v) {
                    for (int i = 1; i <= n; i++) {
                        if (cost[i][u] != Integer.MAX_VALUE && dist[i] != Integer.MAX_VALUE && dist[u] > dist[i] + cost[i][u]) {
                            dist[u] = dist[i] + cost[i][u];
                        }
                    }
                }
            }
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int n = 5; // Number of vertices
        int source = 1; // Source vertex

        // Cost matrix (INF indicates no edge between vertices)
        int[][] cost = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 6, 7, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {0, Integer.MAX_VALUE, 0, 8, 5, -4},
            {0, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, -3, 9},
            {0, Integer.MAX_VALUE, -2, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
            {0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 0}
        };

        // Array to store the shortest path distances
        int[] dist = new int[n + 1];

        // Compute the shortest paths
        bellmanFord(source, cost, dist, n);

        // Print the shortest path distances
        System.out.println("Shortest path distances from vertex " + source + ":");
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + ": INF");
            } else {
                System.out.println("Vertex " + i + ": " + dist[i]);
            }
        }
    }
}
