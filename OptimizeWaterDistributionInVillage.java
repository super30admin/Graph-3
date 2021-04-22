//TC:O(ElogE)
//SC:O(V+E)
//Did it run successfully on Leetcode?:Yes
class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int size){
            parent = new int[size+1];
            rank = new int[size+1];
            Arrays.fill(rank, 1);
            for (int i = 1; i <= size; i++){
                parent[i] = i;
            }
        }
        public boolean union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY)
                return false;
            else if (rank[parentX] < rank[parentY]){
                rank[parentX] = rank[parentX] + rank[parentY];
                parent[parentX] = parentY;
            }else {
                rank[parentY] = rank[parentY] + rank[parentX];
                parent[parentY] = parentX;
            }
            return true;
        }
        public int find(int x){
            if (x != parent[x]){
               parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int cost = 0;
        DSU dsu = new DSU(n);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for (int i = 0; i < wells.length; i++){
            maxHeap.offer(new int[]{0, i+1, wells[i]});
        }
        for (int[] pipe: pipes){
            maxHeap.offer(pipe);
        }
        
        while (!maxHeap.isEmpty()){
            int[] currPipe = maxHeap.poll();
            if (dsu.union(currPipe[0], currPipe[1])){
                cost = cost + currPipe[2];
            }
        }
        return cost;
    }
}
