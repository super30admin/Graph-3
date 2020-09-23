// Time Complexity : O(n+k log(n+k)) --> where n is number of wells and k is number of pipes
// Space Complexity : O(n+k)
// Did this code successfully run on Leetcode (1168): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int uf[];
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        uf = new int[n+1];
        // making each node parent of itself
        for (int i = 1; i <= n; i++) uf[i] = i;
        int cost = 0;
        List<int []> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            edges.add(new int[] {0, i, wells[i-1]});
        }
        for (int [] pipe : pipes) edges.add(pipe);
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        
        for(int [] edge : edges) {
            int x = find(edge[0]);
            int y = find(edge[1]);
            if (x != y) {
                uf[y] = x;
                cost += edge[2];
            }
        }
        return cost;
    }
    
    private int find(int x) {
        if (x != uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }
}