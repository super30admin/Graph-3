
// tc : O(e+n)
// sc : O(n+e)

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);

        for(int[] pipe : pipes)
            pq.add(pipe);
        int[] root = new int[n+1];
        root[0] = 0 ;
        for(int i = 0 ; i<n ; i++){
            pq.add(new int[]{ 0 , i+1, wells[i]});
            root[i+1] = i+1;
        }
        // krushkal algo
        int count = 0 ;
        int result = 0 ;
        while(count < n){
            int[] curr = pq.poll();
            int root1 = find(curr[0], root);
            int root2 = find(curr[1], root);
            if(root1  == root2)
                continue;
            root[root2] = root1;
            count++;
            result+=curr[2];
        }
        return result;
    }

    private int find(int ind, int[] root){
        if(root[ind] != ind)
            root[ind] = find(root[ind], root);
        return root[ind];
    }
}
