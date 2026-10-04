//problem1
class Solution {
    int[] parent;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        this.parent = new int[n + 1];

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

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
//problem2
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] indegrees = new int[n];

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(knows(i,j)){
                    indegrees[i] -- ;
                    indegrees[j] ++;
                }
                if(knows(j,i)){
                    indegrees[j]--;
                    indegrees[i]++;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(indegrees[i] == n-1) return i;
        }

        return -1;
    }
}
