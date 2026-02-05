class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        boolean[] vis = new boolean[n+1];
        List<int[]>[] adj = new ArrayList[n+1];

        for(int i =0; i<=n; i++)
            adj[i] = new ArrayList<>();

        for(int i =0; i< wells.length; i++)
            adj[0].add(new int[] {i+1, wells[i]});
        
        for(int[] pipe : pipes){
            adj[pipe[0]].add(new int[] {pipe[1],pipe[2]});
            adj[pipe[1]].add(new int[] {pipe[0],pipe[2]});
        }


        pq.add(new int[] {0,0});
        int house = 0;
        int minCost =0;

        while(!pq.isEmpty()){
            int currN = pq.peek()[0];
            int currC = pq.peek()[1];
            pq.remove();

            if(vis[currN]) continue;

            minCost += currC;
            vis[currN] = true;
            house++;

            if(house == n+1) return minCost;

            for(int[] child : adj[currN]){
                if(!vis[child[0]])
                    pq.add(new int[] {child[0], child[1]});
            }
        }
    return minCost;
    }
}