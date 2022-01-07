
class Solution {
    int[] parents;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parents = new int[ n + 1 ];
        List<int[]> edges = new ArrayList<>();
        for(int x = 0; x < n; x++){
            edges.add(new int[] { 0, x + 1 , wells[x]});
            parents[ x + 1 ] = x + 1;
        }
        for(int[] pipe: pipes) edges.add(pipe);
        //print(edges);
        
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        int cost = 0, elem = 0;
        for(int[] edge: edges){
            if(elem == n)
                break;
            
            int Px = Union(edge[0]);
            int Py = Union(edge[1]);
            
            if(Px != Py){
                parents[Py] = Px;
                cost += edge[2];
                elem++;
            }
        }
        return cost;
    }
    private int Union(int val){
        if(val != parents[val])
            parents[val] = Union(parents[val]);
        return parents[val];
    }
}