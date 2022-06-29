//TC : O((V + E) *  log(V + E) ) // V - total no.of houses and E - total edges/pipes between all houses
//Sc : O(V + E)  

class Solution {
    int[] unionFind;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if(n == 0 || wells == null)   return 0;
        
        unionFind = new int[n+1];
        
        
        for(int i = 0; i <= n; i++){
            unionFind[i] = i;
        }
        
        List<int[]> costs = new ArrayList<>();
        
        for(int w = 0; w < wells.length; w++){
            costs.add(new int[]{0, w+1, wells[w] });
        }
        for(int[] p : pipes){
            costs.add(p);
        }
        
        Collections.sort(costs, (a,b) -> a[2] - b[2]);
        
        int cost = 0;
        for(int[] curr : costs){
            int px = find(curr[0]);
            int py = find(curr[1]);
            if(px != py){
                cost += curr[2];
                unionFind[px] = py; // or unionFind[py] = px;
            }
        }
        return cost;
    }
    
    public int find(int x){//find parent of node
        if(x != unionFind[x]){
            unionFind[x] = find(unionFind[x]);
        }
        return unionFind[x];
    }
}
