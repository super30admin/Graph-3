import java.util.*;
public class DistributeWaterInVillage {
    static int[] parent;
    static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        List<int[]> edges = new ArrayList<>();
        for (int[] pipe : pipes) {
            edges.add(pipe);
        }
        for (int i = 1; i <= n; i++) {
            edges.add(new int[] {0, i, wells[i - 1]});
        }
        int result = 0;
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            int px = find(x);
            int py = find(y);

            if (px != py) {
                result += edge[2];
                parent[py] = px;
            }
        }
        return result;
    }
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void main(String[] args) {
        int n = 3;
        int[] wells = {1,2,2};
        int[][] pipes = {{1,2,1},{2,3,1}};

        System.out.println("Minimum Cost To Supply water: "+ minCostToSupplyWater(n, wells, pipes));
    }
}
