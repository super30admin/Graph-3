// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    
    Map<Integer, List<int[]>> graph;
    PriorityQueue<int[]> minHeap;
    Set<Integer> visited;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        buildGraph(n, wells, pipes);
        visited.add(0);
        return minCostPrims(n);
    }
    
    private int minCostPrims(int n) {
        int totalCost = 0;
        while(!minHeap.isEmpty()) {
            int[] nextMin = minHeap.remove();
            if(visited.size() == n+1)
                break;
            if(visited.contains(nextMin[0]))
                continue;
            totalCost += nextMin[1];
            visited.add(nextMin[0]);
            for(int[] neighboringNodes: graph.get(nextMin[0])) {
                if(!visited.contains(neighboringNodes[0])) {
                    minHeap.add(new int[] {neighboringNodes[0], neighboringNodes[1]});
                }
            }
        }
        return totalCost;
    }
    
    private void buildGraph(int n, int[] wells, int[][] pipes) {
        for(int i=0;i<=n;i++) graph.put(i, new ArrayList<>());
        
        for(int i=0;i<wells.length;i++) {
            graph.get(0).add(new int[] {i+1, wells[i]});
            minHeap.add(new int[] {i+1, wells[i]});
        }
        
        for(int[] pipe: pipes) {
            graph.get(pipe[0]).add(new int[] {pipe[1], pipe[2]});
            graph.get(pipe[1]).add(new int[] {pipe[0], pipe[2]});
        }
    }
}