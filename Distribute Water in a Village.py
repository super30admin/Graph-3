'''
Time Complexity: O(n^2)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Create a node 0 for water to go from well to houses.
Implement Kruskals Algorithm to get the minimum spanning tree for the cost.
Use Union find as a way to implement Kruskals Algorithim in this sort all edges by cost (as we want min cost) and then
for each edge check if there is a cycle or not ie whether 2 edges belong to same set if yes -> then no need to add cost
ie there already exists a route to the edge in a more effecient way.
Eg if 3 sets A,B,C is we do A union B and B union C -> ABC are already connected, now if we do A union C this is not needed
as the A and C are already connected through.
'''


class DisJoint:
    def __init__(self, size):
        self.rep = [0 for i in range(size)]
        self.rank = [0 for i in range(size)]
        self.components = size
        self.makeSet(size)

    def makeSet(self, size):
        for i in range(size):
            self.rep[i] = i

    def find(self, x):
        if self.rep[x] != x:
            # path compression
            self.rep[x] = self.find(self.rep[x])

        return self.rep[x]

    def union(self, x, y):
        repX = self.find(x)
        repY = self.find(y)
        if repX == repY:
            # same set
            return False
        elif self.rank[repX] < self.rank[repY]:
            self.rep[repX] = repY
        elif self.rank[repX] > self.rank[repY]:
            self.rep[repY] = repX
        else:
            # same rank promote one
            self.rep[repY] = repX
            self.rank[repX] += 1
        self.components -= 1
        return True


class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        edges = []
        for pipe in pipes:
            edges.append(pipe)

        # Adding wells
        # Format is {0,node, cost} -> node is the 0->node
        for i in range(0, len(wells)):
            edges.append([0, i + 1, wells[i]])

        # Sort edges as we want minimum spanning tree, sort on cost
        edges = sorted(edges, key=lambda edges: edges[2])

        # create disjoin of number of nodes + 0 node
        ds = DisJoint(n + 1)
        cost = 0
        for edge in edges:
            if ds.union(edge[0], edge[1]):
                cost += edge[2]

        return cost
