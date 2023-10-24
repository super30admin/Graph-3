import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Time Complexity : O(V+E) + O(E log E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes

public class WaterDistributionInAVillage {
    int uf[];
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        uf = new int[n+1];

        for(int i=0; i<uf.length; i++){
            uf[i] = i;
        }

        List<int[]> edges = new ArrayList<>();

        for(int i=1; i<=n; i++){
            edges.add(new int[]{0,i,wells[i-1]});
        }
        for(int[] pipe : pipes){
            edges.add(pipe);
        }

        Collections.sort(edges, (a, b)-> a[2] - b[2]);
        int result = 0;
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];

            int px = find(x);
            int py = find(y);

            if(px != py){
                result += edge[2];
                // uninize
                uf[px] = py;
            }
        }

        return result;
    }

    private int find(int x){

        if(uf[x] != x){
            uf[x] = find(uf[x]);  // path reduction
        }

        return uf[x];
    }
}