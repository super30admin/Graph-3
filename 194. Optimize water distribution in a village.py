class Solution:
    # Creating a union find array
    uf = 0

    def minCostToSupplyWater(self, n, wells, pipes):
        self.uf = [i for i in range(n + 1)]  # Union array initialized with every node as its own parent
        edges = list()
        # Appending all the edges cases in edges array
        for i in range(1, len(wells) + 1):
            edge = [0, i, wells[i - 1]]
            edges.append(edge)
        for pipe in pipes:
            edges.append(pipe)
        # sorting all the edges according to the cost
        edges.sort(key=lambda x: (x[-1], x[0]))

        result = 0  # to store the total amount

        for edge in edges:
            x = edge[0]
            y = edge[1]
            px = self.find(x)
            py = self.find(y)

            if py != px:  # if nodes are not connected
                self.uf[px] = py  # establish connection
                result += edge[2]  # add to the total cost
        print(result)
        return result

    def find(self, x):
        if self.uf[x] != x:
            self.uf[x] = self.find(self.uf[x])

        return self.uf[x]


n = 3
wells = [1, 2, 2]
pipes = [[1, 2, 1], [2, 3, 1]]

n2 = 2
wells2 = [1, 1]
pipes2 = [[1, 2, 2]]

if __name__ == "__main__":
    obj = Solution()
    obj.minCostToSupplyWater(n, wells, pipes)
    obj.minCostToSupplyWater(n2, wells2, pipes2)

# Disjoint Set Data Structure or Union-Find Algorithm and Path Compression
# Time Complexity: O(V + E)
# Space Complexity:O(V + E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
