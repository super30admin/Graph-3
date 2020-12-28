// 1168.
// time - O((v + e) * log(v + e))
// space - O(v) - parent[]
class Solution {
    
    int[] parent; //accounts for dummy node too
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        parent = new int[n + 1];
        
        List<int[]> edges = new ArrayList<>(); //edges including pipes & wells(edge b/w node where well is built & dummy node)
        for(int i = 1; i <= n; i++)
        {
            //for each village
            int[] currentEdge = {0, i, wells[i - 1]}; //source - dummy node, dest - i, weight - wells[i - 1]
            edges.add(currentEdge);
            parent[i] = i; //initially all villages are inividual groups (make set in union-find)
        }
        for(int[] pipe : pipes)
        {
            edges.add(pipe); //adding pipes to edge list
        }
        
        //sort edge list based on increasing order of costs
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        
        int cost = 0; //return value
        
        for(int[] edge : edges)
        {
            int parentSource = find(edge[0]); //find parent of source
            int parentDest = find(edge[1]); //find parent of dest
            //if source and dest belongs to different groups
            if(parentSource != parentDest)
            {
                cost += edge[2]; //add this edge to result
                parent[parentDest] = parentSource; //make the parent of find(dest) as find(source)
            }
        }
        
        return cost;
    }
    
    private int find(int node) {
        //as long as current node and its parent are not same, update and recurse
        if(parent[node] != node)
        {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
}
