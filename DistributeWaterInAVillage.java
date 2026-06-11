// Time Complexity : O(ElogV)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use Prim's algorithm to find the minimum total cost as mapping to solving a minimum spanning tree problem.
We construct the edges for the wells with vertex 0 and and add them, pipes to the edges list. Using this, we
construct an adjacency map using bidirectional mappings of nodes to their corresponding edges with cost. We
have a priority queue(min heap) to always choose cheapest edge and add 0,0 initially and later start
traversing through the tree by visiting the neighbours of the nodes only if they are unvisited. To check
this, we maintain a visited array to avoid duplicate visits.We update our result value with the input cost
for every edge we visit and return at the last.
 */
class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++) {
            edges.add(new int[] {0, i, wells[i - 1]});
        }

        for(int[] pipe : pipes) {
            edges.add(pipe);
        }

        int result = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();

        //build adjacency map
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(new int[] {v, cost});
            map.get(v).add(new int[]{u, cost});
        }

        //visited array
        boolean[] visited = new boolean[n + 1];

        //Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            if(visited[node])
                continue;
            visited[node] = true;
            result += weight;

            List<int[]> list = map.get(node);
            for(int[] edge : list) {
                if(!visited[edge[0]])
                    pq.add(new int[]{edge[0], edge[1]});
            }
        }

        return result;
    }
}