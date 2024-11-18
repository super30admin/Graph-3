// Problem 1168. Optimize Water Distribution in a Village
// Time Complexity : O((m+n)⋅log(m+n))
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    int[] uf;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        this.uf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            uf[i] = i;
        }

        List<int[]> edges = new ArrayList<>();
        for (int[] pipe : pipes) {
            edges.add(pipe);
        }

        for (int i = 1; i <= n; i++) {
            edges.add(new int[]{0, i, wells[i - 1]});
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        int result = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int px = find(x);
            int py = find(y);
            if (px != py) {
                uf[py] = px; // unionize
                result += edge[2];
            }
        }
        return result;
    }
    private int find(int x) {
        if (uf[x] != x) {
            uf[x] = find(uf[x]); // path compression
        }
        return uf[x];
    }
}