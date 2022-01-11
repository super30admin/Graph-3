class Solution{
    int [] uf;
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes){
        //disjoint set
        
        uf = new int[n+1];
      
        for(int i = 0; i < uf.length; i++){
            uf[i] = i;
        }
        
        List<int []> edges = new ArrayList<>();
        for(int [] pipe: pipes){
            edges.add(pipe);
        }
      
        //add the wells edge with a dummy village 0;
      
        for(int i = 1;i <= n;i++){
            edges.add(new int[]{0, i, wells[i-1]});
        }
        
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        
        int result = 0;
        
        for(int [] edge: edges){
            int px = find(edge[0]);
            int py = find(edge[1]);
            if(px != py){
                //unionize
                result += edge[2];
                uf[px] = py;
            }
        }
        return result;
    }
    private int find(int x){
        if(uf[x] != x){
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}


//TC: O(V+E)
//SC: O(E)
