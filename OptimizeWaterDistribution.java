// Time Complexity : O(V+ElogE)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No 

// Your code here along with comments explaining your approach
// reduce the cost by unionsing all the vertices by sorting edges and getting minimal cost
// we need to unionize one vertex with another if both share different parent
// if they share same parent - already in the same group
// in path reduction -> we update the parent of x to the main parent of the group recursively

class Solution {

    private int[] parent;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        List<int[]> edges = new ArrayList<>();
        for (int[] pipe : pipes)
            edges.add(pipe);
        for (int i = 0; i < wells.length; i++) {
            edges.add(new int[] { 0, i + 1, wells[i] });
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        int cost = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int px = find(x);
            int py = find(y);

            if (px != py) {
                parent[py] = px;
                cost += edge[2];
            }
        }

        return cost;

    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}