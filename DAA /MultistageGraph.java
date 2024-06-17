// MultistageGraph forward approach

import java.util.Arrays;

public class MultistageGraph {
    static final int INF = Integer.MAX_VALUE;
    
    // Method to find the minimum-cost path in a multistage graph
    public static void FGraph(int[][] c, int k, int n, int[] p) {
        double[] cost = new double[n + 1];
        int[] d = new int[n + 1];
        
        Arrays.fill(cost, INF);
        cost[n] = 0.0;
        
        for (int j = n - 1; j >= 1; j--) {
            for (int r = j + 1; r <= n; r++) {
                if (c[j][r] != INF && cost[j] > c[j][r] + cost[r]) {
                    cost[j] = c[j][r] + cost[r];
                    d[j] = r;
                }
            }
        }
        
        // Find a minimum-cost path
        p[1] = 1;
        p[k] = n;
        for (int j = 2; j <= k - 1; j++) {
            p[j] = d[p[j - 1]];
        }
    }
    
    // Main method to test the algorithm
    public static void main(String[] args) {
        int n = 8; // Number of vertices
        int k = 4; // Number of stages
        
        // Cost matrix (INF indicates no edge between vertices)
        int[][] c = {
            {0, INF, INF, INF, INF, INF, INF, INF, INF},
            {INF, 0, 2, 1, INF, INF, INF, INF, INF},
            {INF, INF, 0, INF, 2, 3, INF, INF, INF},
            {INF, INF, INF, 0, 3, 4, 1, INF, INF},
            {INF, INF, INF, INF, 0, INF, 2, 1, INF},
            {INF, INF, INF, INF, INF, 0, INF, 1, 3},
            {INF, INF, INF, INF, INF, INF, 0, INF, 2},
            {INF, INF, INF, INF, INF, INF, INF, 0, 2},
            {INF, INF, INF, INF, INF, INF, INF, INF, 0}
        };
        
        // Array to store the minimum-cost path
        int[] p = new int[k + 1];
        
        // Compute the minimum-cost path
        FGraph(c, k, n, p);
        
        // Print the minimum-cost path
        System.out.println("The minimum-cost path is:");
        for (int i = 1; i <= k; i++) {
            System.out.print(p[i] + (i == k ? "\n" : " -> "));
        }
    }
}
