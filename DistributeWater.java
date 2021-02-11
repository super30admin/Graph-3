//Time Complexity : O(E LOG E) for Brute Force,O(N) for Logical Deduction 
//Space Complexity : O(N) for Both Approaches
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
To solve this problem,we need to form a connected graph to find minimum cost.
Algo steps are mentioneed below:

1. Create a dummy node with id 0
2. Construct edge with all house/nodee to this  dummy node.The weight of edges will be wells[i].
Now our graph is completely connected .We have used adajaceny list.Now this problems reduces to find Minimum Spanning Tree in graph
3. Also declare a dummy array with size n + 1 for apply union find to merge nodes
3. Sort the adajacent list based on weight of edges.
4. Now start iterating the adajacent list and perfoem following steps:
    1. Extract first and second edge from list.Let edges be vertex1 and vertex2
    2. Find parent of both nodes using union find algorthim.Let corresponding parents are xPar,yPar
    3. If xPar != yPar, it means nodes are not connected.Union both nodes by parent[xPar] = yPar;
    4. Also add the edge weigth to result
5. Repeat above steps until all vertex are merged or adajacent list is processed
*/ 

public class DistributeWater {
    int []uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        uf = new int[n + 1];
        List<int[]> edges = new ArrayList<>();
        for(int i =0; i < n; i++){
            edges.add(new int[]{0,i + 1,wells[i]});
            uf[i + 1 ] = i + 1;
        }
        for(int pipe[] : pipes){
            edges.add(pipe);
        }
        Collections.sort(edges, (e1,e2) -> e1[2] - e2[2]);
        int totalCost = 0;
        for(int edge[] : edges){
            int xPar = find(edge[0]);
            int yPar = find(edge[1]);
            int cost = edge[2];
            if(xPar != yPar){
                totalCost += edge[2];
                uf[yPar] = xPar;
            }
        }
        return totalCost;
    }

    public int find(int x ){
        if(uf[x] != x){
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}