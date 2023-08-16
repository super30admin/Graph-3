class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        
        // Create a virtual node 0 connected to all wells
        for (int i = 0; i < n; i++) {
            edges.add(new int[] {0, i + 1, wells[i]});
        }
        
        // Add pipes to the edges list
        for (int[] pipe : pipes) {
            edges.add(pipe);
        }
        
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            int parentU = find(parent, u);
            int parentV = find(parent, v);
            
            if (parentU != parentV) {
                parent[parentU] = parentV;
                totalCost += cost;
            }
        }
        
        return totalCost;
    }
    
    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}

