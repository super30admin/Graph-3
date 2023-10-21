// Time Complexity :O(eloge)
// Space Complexity :O(e)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        this.uf = new int[n+1];
        int result = 0;
        for(int i=0; i<n+1; i++){
            uf[i] = i;
        }

        List<int[]> edges = new ArrayList<>();

        for(int i=0; i<n; i++){
            edges.add(new int[]{0, i+1, wells[i]});
        }

        for(int[] pipe: pipes){
            edges.add(pipe);
        }

        Collections.sort(edges, (a,b) -> (a[2] - b[2]));

        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            int px = find(x);
            int py = find(y);
            if(px != py){
                result += edge[2];
                uf[py] = px;
            }
        }

        return result;
    }

    private int find(int x){
        if(uf[x] == x) return x;

        uf[x] = find(uf[x]);

        return uf[x];
    }
}