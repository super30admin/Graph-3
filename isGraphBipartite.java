/*
Problem: https://leetcode.com/problems/is-graph-bipartite/

// TC: O(v + e)
// SC: O(v)
*/


// Approach 1: DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return true;
        
        int n = graph.length;
        int colors[] = new int[n];
        Arrays.fill(colors, -1);
        
        for (int node = 0; node < n; ++node) {
            if (colors[node] == -1) {
                colors[node] = 0;
                if (!dfs(node, graph, colors)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int node, int graph[][], int colors[]) {
        
        for (int i = 0; i < graph[node].length; ++i) {
            int edgeNode = graph[node][i];
            
            if (colors[edgeNode] != -1) {
                if (colors[edgeNode] == colors[node]) {
                    return false;
                }
            } else {
                colors[edgeNode] = (colors[node] == 0 ? 1 : 0);
                if (!dfs(edgeNode, graph, colors)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

// Approach 2: BFS
// TC: O(v + e)
// SC: O(v)
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return true;
        
        int n = graph.length;
        int colors[] = new int[n];
        Arrays.fill(colors, -1);
        
        for (int node = 0; node < n; ++node) {
            if (colors[node] == -1) {
                colors[node] = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(node);
                
                while (!queue.isEmpty()) {
                    int curNode = queue.poll();
                    
                    for (int i = 0; i < graph[curNode].length; ++i) {
                        int edgeNode = graph[curNode][i];
                        
                        if (colors[edgeNode] != -1) {
                            if (colors[edgeNode] == colors[curNode]) {
                                return false;
                            }
                        } else {
                            colors[edgeNode] = (colors[curNode] == 0 ? 1 : 0);
                            queue.offer(edgeNode);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}