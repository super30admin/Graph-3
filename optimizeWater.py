class Solution:
    def minCostToSupplyWater(
        self, n: int, wells: List[int], pipes: List[List[int]]
    ) -> int:
        # T: O(E log E), S: O(1)
        # Initialize parent pointers for Union-Find
        parent = [i for i in range(n + 1)]

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]  # Path compression
                x = parent[x]
            return x

        def union(x, y):
            root_x, root_y = find(x), find(y)
            if root_x == root_y:
                return False
            parent[root_x] = root_y
            return True

        # Add virtual edges from node 0 to each house with well cost
        edges = [[0, i + 1, cost] for i, cost in enumerate(wells)]
        # Add existing pipes
        edges += pipes
        # Sort all edges by cost
        edges.sort(key=lambda x: x[2])

        total_cost = 0
        for u, v, cost in edges:
            if union(u, v):
                total_cost += cost

        return total_cost
