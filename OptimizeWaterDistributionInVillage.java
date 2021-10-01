class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        int[] parents = new int[n+1];
        parents[0] = 0;
        
        List<int[]> edges = new ArrayList<>();
        
        for(int x = 0; x < n; x++){
            edges.add(new int[] {0, x+1, wells[x]});
            parents[x+1] = x+1;
        }
        
        for(int[] pipe : pipes){
            edges.add(pipe);
        }
        
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        
        int cost = 0;
        
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            
            int parentX = Union(x, parents);
            int parentY = Union(y, parents);
            
            if(parentX != parentY){
                cost += edge[2];
                parents[parentY] = parentX;
            }
            
        }
        
        return cost;
        
    }
    
    private int Union(int val, int[] parents){
        if(val != parents[val]){
            parents[val] = Union(parents[val], parents);
        }
        
        return parents[val];
    }
}