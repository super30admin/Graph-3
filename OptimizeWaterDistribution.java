// Time Complexity : O(E log E) + O(E*V) (where E is V+#E in pipes)
// Space Complexity : O(V+E) 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// add new edges from a dummy node to houses with edge cost as wells[i-1], now form a MST
// sort all edges and pick least cost, keep joining till MST is formed, use union find to keep track of cur node union parent

class Solution {
    int[] parent;
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        List<int[]> edges = new ArrayList<>();
        for(int i=1; i<=n; i++){
            edges.add(new int[]{0, i, wells[i-1]});
        }
        
        for(int i=0; i<pipes.length; i++){
            edges.add(pipes[i]);
        }
        
        Collections.sort(edges, (a, b) -> a[2]-b[2]);
        
        this.parent = new int[n+1];
        for(int i=0; i<parent.length; i++){
            this.parent[i] = i;
        }
        
        int overallCost = 0;
        for(int[] edge : edges){
            int parentSrc = unionFind(edge[0]);
            int parentDest = unionFind(edge[1]);
            
            if(parentSrc != parentDest){
                overallCost += edge[2];
                this.parent[parentDest] = parentSrc;
            }
        }
        
        return overallCost;
    }
    
    private int unionFind(int node){
        if(this.parent[node]!=node){
            this.parent[node] = unionFind(this.parent[node]);
        }
        
        return this.parent[node];
    }
}