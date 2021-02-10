# TIME COMPLEXITY: O(N log N)
# SPACE COMPLEXITY: O(N)

# Define the Union-Find Datastructure
class UnionFind:
    def __init__(self, numNodes):
        # Maintain an array with component id
        # Component id represents which connected component a node belongs to
        # To start, assume every node is it's own component
        # parent[node] = node
        self.n = numNodes
        self.parent = [i for i in range(numNodes)]
        self.size = [1 for _ in range(numNodes)]
        self.components = numNodes
        self.total_cost = 0

    # FIND with path compression - O(log n)
    # Amortized complexity of find with path compression is "practically constant".
    def find(self, x):
        # Base Case
        if x == self.parent[x]:
            return x
        
        # Recursive Case
        root_x = self.find(self.parent[x])
        self.parent[x] = root_x
        return root_x
    
    # Weighted Quick Union - O(1) per union operation
    def quick_union(self, u, v, cost):
        root_u = self.find(u)
        root_v = self.find(v)
        # UNION O(1)
        if root_u != root_v:
            if self.size[root_u] < self.size[root_v]:
                self.parent[root_u] = root_v
                self.size[root_v] += self.size[root_u]
            else:
                self.parent[root_v] = root_u
                self.size[root_u] += self.size[root_v]
            self.components -= 1
            self.total_cost += cost

    def get_components(self):
        return self.components
    
    def get_cost(self):
        return self.total_cost

class Solution(object):
    def minCostToSupplyWater(self, n, wells, pipes):
        """
        :type n: int
        :type wells: List[int]
        :type pipes: List[List[int]]
        :rtype: int
        """
        # The trick here is to consider digging wells as laying pipes from a dummy house '0' to every other house
        # Add connections from dummy house to all other houses in the pipes array
        for i, cost in enumerate(wells):
            pipes.append([0, i+1, cost])
        
        # Sort pipes by cost
        pipes.sort(key=lambda x:x[2])
        
        # Initialize the union find datastructure
        uf = UnionFind(len(wells)+1)
        
        # Kruskal's Algorithm 
        # Greedy algorithm to build a MST. Built on top of Union Find. Repetedly add edges to nodes in increasing order of cost if they don't form a cycle. When the number of components == 1, return the total cost.
        for u, v, cost in pipes:
            uf.quick_union(u-1, v-1, cost)
            if uf.get_components() == 1:
                # All nodes are unified in a single component, return the cost
                return uf.get_cost()
        
        return -1
