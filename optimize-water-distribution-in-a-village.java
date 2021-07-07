// Time Complexity : Sorting of edges O(ELogE) time
for each edge we apply find-union algorithm, so the find and union operations can take atmost O(LogV) time
therefore overall complexity is O(ELogE + ELogV) = O(ElogE) or O(ElogV) because E=O(V^2), so O(LogV) are O(LogE) same.
// Space Complexity : O(1)

class Solution {
    private int[] rep;
    private int[] rank;
    
    //init each entry/point/node with rank 0 and rep to itself
    private void makeSet(int size) {
        rep = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++)
            rep[i]=i;
    }
    
    //find also perform path compression
    //this is the crux that makes union-find so effecient
    private int find(int x) {
        if(rep[x] != x)
            rep[x] = find(rep[x]);
        return rep[x];
    }
    
    //union x and y
    //returns trues if union is actually performed else false if both of them are in same set 
    boolean union(int x, int y) {
        int repX=find(x), repY=find(y);
        if(repX == repY)
            return false; //same set
        else if(rank[repX] < rank[repY])
            rep[repX]=repY;
        else if(rank[repY] < rank[repX]))
            rep[repY]=repX;
        else {
            rep[repY]=repX;
            rank[repX]++;
        }
        return true;
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<size;i++) {
            edges.add(new int[]{0, i+1, wells[i]});
        }
        
        for(int[] pipe : pipes)
            edge.add(pipe);
        
        Collection.sort(edges, (a, b) -> a[2]-b[2]);
        
        makeSet(n+1);
        
        int cost=0;
        for(int[] edge:edges) {
            if(union(edge[0], edge[1]))
                cost+=edge[2];
        }
        return cost;
    }
}
