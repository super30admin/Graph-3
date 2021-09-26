import java.util.*;

public class OptimizedWaterDistribution {

    // Houses are disconnected, we need to connect them. If we connect any of them
    // others will be connected automatically.
    // Union Find approach will be build a wall for cheapest cost and connect the
    // all houses using pipes.
    // So, Assuming Dummy house pipe connection equalent to wall cost.
    // And form edges between all nodes. And star union operation - If it is in same
    // parent no need any action as the houses are already connected. Else increase the cost and make them in a same group.
    // to find the chepest cost to union first - Sort them based on cost.

    //TC: O(V+ E LogE) - Where E is no of edges. Since we sorting It is E LogE. Find parent Asymptomtically O(1)
    //SC: O(V+E)  Where V is number of Vertices and E is number of edges.
    int[] unionFind;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int cost = 0;
        unionFind = new int[n + 1];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }

        List<int[]> edges = new ArrayList();

        for (int[] pipe : pipes) {
            edges.add(pipe);
        }

        for (int i = 1; i <= wells.length; i++) {
            edges.add(new int[] { 0, i, wells[i - 1] });
        }

        Collections.sort(edges, (a, b) -> (a[2] - b[2]));

        for (int[] edge : edges) {
            int px = findParent(edge[0]);
            int py = findParent(edge[1]);

            if (px != py) {
                cost += edge[2];
                unionFind[px] = py;
            }
        }

        return cost;
    }

    private int findParent(int x) {
        if (unionFind[x] != x) {
            unionFind[x] = findParent(unionFind[x]);
        }
        return unionFind[x];
    }

    public static void main(String[] args) {
        OptimizedWaterDistribution optimizedWaterDistribution = new OptimizedWaterDistribution();
        int cost = optimizedWaterDistribution.minCostToSupplyWater(3, new int[]{1,2,2}, new int[][]{{1,2,1}{2,3,1}});
        System.out.println("The minimum cost: "+cost);

    }
}