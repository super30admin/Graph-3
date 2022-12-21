import java.util.PriorityQueue;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

/*
    first make connected components from pipes array to know which all houses are connected and each set should have atleast one well.
    then we will place the well as virtual node in the set and calculate the MST.
    return sum of minimums of sets
    
    index 0 is my dummy node
*/

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n+1);
        PriorityQueue<int[]> adjacencyList = new PriorityQueue<>((a,b)->a[2]-b[2]);
        //wells index 0
        for(int i = 0; i < wells.length; i++){
            adjacencyList.add(new int[]{0, i+1, wells[i]});
        }
        //pipes
        for(int i = 0; i < pipes.length; i++){
            int[] curr_pipe = pipes[i];
            adjacencyList.add(new int[]{curr_pipe[0], curr_pipe[1], curr_pipe[2]});
        }
        //get mst
        int count = n, cost = 0;
        while(!adjacencyList.isEmpty()){
            int[] curr = adjacencyList.poll();
            if(!uf.isConnected(curr[0],curr[1])){
                uf.union(curr[0],curr[1]);
                cost += curr[2];
            }
        }
        return cost;
    }
}
class UnionFind{
    int[] root, rank;
    int count;
    public UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        count = size;
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
    public void union(int x, int y){
        int rootX = find(x), rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else
                root[rootY] = rootX;
                rank[rootX] += 1;
            count--;    
        }
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    public int getCount(){
        return count;
    }
}

