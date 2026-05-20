/**
 * Simulate snowfall and melting for each day, then compute the mountain profile and check
 * whether crossing is possible by ensuring adjacent height differences are at most 1.
 * Track the valid day requiring the minimum total climbs across all forecast days.
 * Time Complexity: O(A * D)
 * Space Complexity: O(A)
 */

public class WaterDIstribution {
    int[] parent;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        this.parent = new int[n+1];

        for(int i = 1; i <=n ; i++) {
            parent[i] = i;
        }

        List<int[]> edges = new ArrayList<>(); 

        for(int[] pipe: pipes) {
            edges.add(pipe);
        }

        for(int i = 1; i <=n ; i++) {
            edges.add(new int[]{0,i,wells[i-1]});
        }

        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        int result = 0;

        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            int px = find(x);
            int py = find(y);

            if(px != py) {
                result += edge[2];
                parent[px] = py; //x is surrendered to y
            }

        }
        return result;
    }

    private int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]); // path reduction
            //return find(parent[x]);
        }
        return parent[x];
    }
}    

