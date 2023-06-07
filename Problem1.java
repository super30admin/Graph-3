import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Distribute Water in a Village
approach: use union all concept by sorting the pipes array
time: O((V+E) log (V+E))
space: O(V+E)
 */
public class Problem1 {
    int[] unionFindArray;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int minCost = 0;
        unionFindArray = new int[n+1];

        for (int i=0;i<=n;i++) {
            unionFindArray[i] = i;
        }

        List<int[]> edges = new ArrayList<>();

        for (int j=0;j<wells.length;j++) {
            edges.add(new int[]{0,j+1,wells[j]});
        }

        for (int[] edge: pipes) {
            edges.add(edge);
        }

        Collections.sort(edges, (a,b) -> a[2]-b[2]);
        int count = 0;

        for (int[] edge:edges) {
//            find eventual parents
            int x = edge[0], y = edge[1];
            int px = findParent(x), py = findParent(y);

            if (px!=py) {
                unionFindArray[px] = py;
                minCost+=edge[2];
                count++;
                if (count==n) return minCost;
            }
        }

        return minCost;
    }

    private int findParent(int x) {
        if (unionFindArray[x]!=x) {
            return findParent(unionFindArray[x]);
        }
        return x;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int x = problem1.minCostToSupplyWater(4, new int[]{1,2,2,1}, new int[][]{{1,2,1},{2,3,1},{1,4,3}});
        System.out.println("mincost "+x);
    }
}
