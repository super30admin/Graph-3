// Time Complexity : O(N+M)log(N+M) where N & M are the size of wells and pipes arrays
// Space Complexity : O(N+M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use Disjoint Union find technique here
// Consiter an extra house with house no. as 0, and this the the borewell location
// For all the houses the borewell cost would be associated with house 0
// The pipes array would be used to add the edges for pipes
// Now we will have the graph with costs
// The sum of cost of minimum spanning tree would be our answer
// Now we will use the Kruskal algo to solve this and return the sum

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<Edge> edges= new ArrayList<>();
        for(int house = 1; house <= n; house++){
            edges.add(new Edge(0, house, wells[house-1]));
        }
        for(int i = 0; i < pipes.length; i++){
            edges.add(new Edge(pipes[i][0], pipes[i][1], pipes[i][2]));
        }
        Collections.sort(edges, (a, b) -> a.cost - b.cost);
        DSU dsu = new DSU(n + 1);
        int cost = 0;
        for(Edge edge: edges){
            if(dsu.union(edge.house1, edge.house2)){
                cost += edge.cost;
            }
        }
        return cost;
    }
}
class Edge{
    int house1, house2, cost;
    Edge(int house1, int house2, int cost){
        this.house1 = house1;
        this.house2 = house2;
        this.cost = cost;
    }
}
class DSU{
    private int[] parent;
    private int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    public int find(int v){
        if(parent[v] == v)
            return v;
        parent[v] = find(parent[v]);
        return parent[v];
    }
    public boolean union(int u, int v){
        int parentU = find(u);
        int parentV = find(v);
        if(parentU == parentV)
            return false;
        if(rank[parentU] > rank[parentV])
            parent[parentV] = parentU;
        else if(rank[parentU] < rank[parentV])
            parent[parentU] = parentV;
        else{
            parent[parentU] = parentV;
            rank[parentV]++;
        }
        return true;
    }
}