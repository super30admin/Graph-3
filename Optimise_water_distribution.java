


class Solution {
    
    int[] parent;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        parent = new int[n+1];
        List<int[]> edges = new ArrayList<>();
        for(int x=0; x<n; x++){
            edges.add(new int[]{0,x+1,wells[x]});
            parent[x+1]= x+1;
        }
        
        for(int[] pipe: pipes){
            edges.add(pipe);
        }
        
        Collections.sort(edges, (a,b) -> a[2]-b[2]);
        
        int cost = 0;
        for(int[] edge : edges){
            int x = Union(edge[0]);
            int y = Union(edge[1]);
            
            if(x!=y){
                cost+= edge[2];
                parent[y]= x;
            }
            
        }
        return cost;
    }
    private int Union(int val){
        if(val!= parent[val]){
            parent[val]= Union(parent[val]);
        }
        return parent[val];
    }
    
}
