/*
Problem: https://leetcode.com/problems/optimize-water-distribution-in-a-village/

There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[i] = [house1, house2, cost] represents the cost to connect house1 and house2 together using a pipe. Connections are bidirectional.

Find the minimum total cost to supply water to all houses.

Example 1:

Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: 
The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.

Constraints:

1 <= n <= 10000
wells.length == n
0 <= wells[i] <= 10^5
1 <= pipes.length <= 10000
1 <= pipes[i][0], pipes[i][1] <= n
0 <= pipes[i][2] <= 10^5
pipes[i][0] != pipes[i][1]
*/

class Main {
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n);
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            edges.add(new int[]{0, i + 1, wells[i]});
        }
        
        for (int[] pipe : pipes) {
            edges.add(pipe);
        }
        
        // Sort edges in inc order of cost
        Collections.sort(edges, (e1, e2) -> e1[2] - e2[2]);
        
        int minCost = 0;
        for (int edgeInfo[] : edges) {
            int x = edgeInfo[0];
            int y = edgeInfo[1];
            int cost = edgeInfo[2];
            
            int px = uf.find(x);
            int py = uf.find(y);
            
            if (px != py) {
                uf.union(x, y);
                minCost += cost;
            }
            /*
            If px == py, they are already part of the same group. So, this edge is redundant.
            Ignore it from the result;
            */
        }
        
        return minCost;
    }
    
    public static void main(String args[]) {
        int n = 3;
        int wells[] = new int[]{1,2,2};
        int pipes[][] = new int[][]{{1,2,1}, {2,3,1}};
        System.out.println(minCostToSupplyWater(n, wells, pipes)); // minimum cost = 3
        
        n = 5;
        wells = new int[]{1,2,2,3,2};
        pipes = new int[][]{{1,2,1}, {2,3,1}, {4,5,7}};
        System.out.println(minCostToSupplyWater(n, wells, pipes)); // minimum cost = 3
    }
}

class UnionFind {
    static int[] representative;
    // Indicates the number of villages in the same group
    static int[] size;
    
    
    public UnionFind(int n) {
        representative = new int[n + 1];
        // Set every node as its own parent initially
        for (int i = 0; i <= n; i++) {
            representative[i] = i;
        }
        // Set rank of every node to 0 initially
        size = new int[n + 1];
    }

    public static int find(int x) {
        if (representative[x] == x) {
            return x;
        }
        
        representative[x] = find(representative[x]);
        return representative[x];
    }
    
    public static void union(int x, int y) {
        int repX = find(x);
        int repY = find(y);
        
        if (repX == repY) {
            return;
        }
        
        if (size[repX] > size[repY]) {
            representative[repY] = repX;
            size[repX] += size[repY];
        } else {
            representative[repX] = repY;
            size[repY] += size[repX];
        }
    }
}