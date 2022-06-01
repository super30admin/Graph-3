// Time Complexity : O(N+M(log(N+M)))   
// Space Complexity : O(N+M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using minimum spanning tree logic

class Solution {
    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if(n == 0 ) return 0;
        uf = new int[n+1];
        for(int i =0; i<n+1; i++)
            uf[i] = i;
        List<int[]> edges = new ArrayList<>();
        for(int i = 1; i<=wells.length; i++){
            int[] edge = {0,i,wells[i-1]};
            edges.add(edge);
        }
        for(int[] pipe : pipes)
            edges.add(pipe);
        Collections.sort(edges,(a,b)-> a[2] -b[2]);
        int cost =0;
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int px = find(x);
            int py = find(y);
            if(px!=py){
                uf[px] = py;
                cost = cost + edge[2];
            }
        }
        return cost;
    }
    public int find(int x){
        if(x != uf[x]){
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}