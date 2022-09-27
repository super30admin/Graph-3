// Time: O((V+E) *  log(V+E) ) // V - total no.of houses and E - total edges/pipes between all houses
// Space: O(V+E)  

class Solution {
    int [] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int result = 0;
        uf = new int [n+1];
        for(int i = 0; i <= n; i++){
            uf[i] = i;
        }
        
        List<int[]> li = new ArrayList<>();
        for(int i = 0; i < wells.length; i++){
            li.add(new int [] {0,i+1,wells[i]});
        }
        
        for(int i = 0; i < pipes.length; i++){
            li.add(pipes[i]);
        }
        
        Collections.sort(li,(a,b)->a[2]-b[2]);
        
        for(int[] edge: li){
            int px = find(edge[0]);
            int py = find(edge[1]);
            if (px != py){
                result += edge[2];
                uf[px] = py;
            }
        }
        return result;
        
    }
    
    private int find(int i){
        if (uf[i] == i) return i;
        uf[i] = find(uf[i]);
        return uf[i];
    }
    
}
