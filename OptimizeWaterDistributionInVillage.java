import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptimizeWaterDistributionInVillage {
    int[] parent;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges=new ArrayList<>();
        parent=new int[n+1];
        for(int i=0;i<wells.length;i++){
            edges.add(new int[]{0,i+1,wells[i]});
            parent[i+1] =i+1;
            System.out.println(parent[i+1]+"--");
        }
        for(int i=0;i<pipes.length;i++){
            edges.add(new int[]{pipes[i][0],pipes[i][1],pipes[i][2]});
        }

        Collections.sort(edges,(a, b)-> a[2]-b[2]);

        //kruskal's algorithm starts

        int cost = 0;

        for(int[] edge : edges){
            System.out.println(edge[0]+"--"+edge[1]+"--"+edge[2]);
            int x = Union(edge[0]);
            int y = Union(edge[1]);

            if(x != y){
                cost += edge[2];
                parent[y] = x;
            }
        }
        return cost;
    }


    private int Union(int val){

        if(val != parent[val]){
            parent[val] = Union(parent[val]);
        }

        return parent[val];

    }
}
