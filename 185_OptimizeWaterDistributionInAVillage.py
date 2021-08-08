'''
Not executed on leetcode(locked problem)
time - O(N)
space - O(N+M),  N- no. of wells(villages), M- pipe connections, N+M - total no. of edges
Approach:
1. create a parent array with n+1 elements, create an edges
list which consists of edges leading to 0(well) node newly created to apply kruskals algorithm.
2. sort the edges list by index 2(edge weight)
3. apply kruskal's algorithm and do union find to find all the minimum weight edges
connecting all n nodes with n-1 edges.
4. Increase the cost each time x!= y is found and at the end return minimum cost.
'''
class Solution:
    global parent;
    def minCostToSupplyWater(self, n, wells, pipes):
        edges = []
        self.parent = [0 for _ in range(n+1)]

        # add edges leading to well(0)
        for x in range(n):
            edges.append([0,x+1,wells[x]])
            self.parent[x+1] = x+1

        # append the edges which are defined as pipes to edges.
        edges += pipes

        # sort the array with index 2 (minimum edge weight first)
        edges.sort(key= lambda x:x[2])

        # kruskal's algorithm starts
        cost = 0
        # iterate through all the edges.
        for edge in edges:
            x = self.Union(edge[0])
            y = self.Union(edge[1])

            # if x and y's parents not equal then they are not connected,
            # connect them using current edge and add the cost.
            if x != y:
                cost += edge[2]
                self.parent[y] = x
                print(self.parent)
        return cost

    # Union-Find
    def Union(self, val):
        if val != self.parent[val]:
            self.parent[val] = self.Union(self.parent[val])
        return self.parent[val]

sol = Solution()
print(sol.minCostToSupplyWater(3, [1,2,2],[[2,3,1],[1,2,1]]))

