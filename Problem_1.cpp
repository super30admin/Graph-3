1168. Optimize Water Distribution in a Village


1. Prim's Algorithm:

Time Complexity: O(N+M)log(N+M)
Space Complexity: O(N+M)


class Solution {
public:
    int minCostToSupplyWater(int n, vector<int>& wells, vector<vector<int>>& pipes) {
        // Min Heap to maintain the order of edges to be visited
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > edgesHeap;
        
        // Representing graph as adjacency list
        vector<vector<pair<int, int>>> graph(n+1);
        
        // Add a virtual vertex indexed with 0, then add an edge(cost, node) to each of the house 
        // weighted by the cost
        for(int i=0; i< wells.size(); i++) {
            // from node 0 to node i+1 with a weight wells[i]
            pair<int, int> virtualEdge = {wells[i], i+1}; 
            graph[0].push_back(virtualEdge);
            // We don't need an edge from i+1 to 0 since we will be starting off with 0.
            // graph[i+1].push_back({wells[i], 0});

            // Initialize the heap with the edges from the virtual vertex
            edgesHeap.push(virtualEdge);
        }
        
        // Add the bidirectional edges to the graph
        for(int i=0; i< pipes.size(); i++){
            int house1 = pipes[i][0];
            int house2 = pipes[i][1];
            int cost   = pipes[i][2];
            
            graph[house1].push_back({cost, house2});
            graph[house2].push_back({cost, house1});
        }
        
        // Prim's Algorithms starts from here on the graph
        // Kick off exploration from the virtual vertex 0
        unordered_set<int> mstSet = {0};
        int totalCost = 0;
        
        // Till all the nodes are added to the mstSet
        while(mstSet.size() < n+1){
            pair<int, int> edge = edgesHeap.top(); 
            edgesHeap.pop();
            
            int cost = edge.first;
            int nextHouse = edge.second;
            
            // If the mst Set already has this house, move ahead since the best cost for it is already considered
            if(mstSet.count(nextHouse))
                continue;
            
            // Insert it into the set and add it's cost.
            mstSet.insert(nextHouse);
            totalCost += cost;
            
            // Push the neighbours of the edge so that we can choose from them as well in the next round
            // Only insert in the set if the mstSet doesn't already have it (This is not necessary since 
            // at the time of popping we are already checking.. but it makes things efficient)
            for(auto nbr: graph[nextHouse]){
                if(!mstSet.count(nbr.second))
                    edgesHeap.push(nbr);
            }
            
        }
        
        return totalCost;
        
    }
};

