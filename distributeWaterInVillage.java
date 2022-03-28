// Time Complexity = O((M+N) log (M+N)), where N = no. of wells and M = no. of pipes
// Space Complexity = O(M+N) for the edges array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We will solve this using Union Find / Disjoint set Union Algorithm
class Solution {
    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if (n == 0) return 0;
        uf = new int[n+1];  // there are n villages and +1 for the well placement (let it be at 0 index)

        // mark each node its parent in uf array
        for (int i=0; i<=n; i++) {
            uf[i] = i;
        }

        // make list of edges
        List<int[]> edges = new ArrayList<>();

        // add wells and its edge costs to edges
        for (int i=1; i<=wells.length; i++) {
            int[] edge = {0, i, wells[i-1]};
            edges.add(edge);
        }

        // add each pipe to edges
        for (int[] pipe: pipes) {
            edges.add(pipe);
        }

        // sort the list on the edge cost
        Collections.sort(edges, (a,b) -> a[2] - b[2]);

        // traverse the sorted edges list to find the optimal way to connect all the vertices with minimum edge costs i.e., minimum spanning tree
        int cost=0;

        for (int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];

            int px = find(x);
            int py = find(y);

            if (px != py) {
                uf[px] = py;
                cost += edge[2];
            }
        }

        return cost;
    }

    // In the find method we are updating the parent to the final parent as well as a result of the unwinding
    // This is known as path compression
    private int find(int x) {
        if (x != uf[x]) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}