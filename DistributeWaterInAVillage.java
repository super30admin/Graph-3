class DistributeWaterInAVillage {

    // Time Complexity: O(m*n)
    // Space Complexity: O(n+k+n)

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[] parent = new int[n+1];
        parent[0] = 0;
        
        List<int[]> edges = new ArrayList<>();
        
        // populating the edges list from both pipes and wells for each node --> (a, b, weight)
        for(int i = 0; i < n; i++){
            edges.add(new int[]{0, i+1, wells[i]});
            parent[i+1] = i + 1;
        }
        
        for(int[] pipe : pipes){
            edges.add(pipe);
        }
        
        // sorting based on weights
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        int cost = 0;
        
        // Applying Kruskal's algorithm --> Minimum Spanning Tree
        for(int[] edge : edges){        //m --> m*n
            int x = edge[0];
            int y = edge[1];
            
            int parentX = Union(x, parent); // n
            int parentY = Union(y, parent);
            if(parentX != parentY){
                cost += edge[2];
                parent[parentY] = parentX;
            }
        }

        return cost;
    }
    
    private static int Union(int val, int[] parents){
        if(val != parents[val])
            parents[val] = Union(parents[val], parents);
        
        return parents[val];
    }
}