# Time Complexity: O(N+M(log(N+M)))
# Space Complexity: O(N+M)

class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        def find(x):
            if uf[x] != x:
                uf[x] = find(uf[x])
            return uf[x]

        if not n:
            return 0
        if not wells and not pipes:
            return 0
        res = 0
        uf = [0 for i in range(n+1)]
        for i in range(n+1):
            uf[i] = i

        edges = []
        for i in range(1, n+1):
            edges.append([0, i, wells[i-1]])

        for pipe in pipes:
            edges.append(pipe)

        edges.sort(key=lambda x: x[2])
        for edge in edges:
            x = edge[0]
            y = edge[1]
            px = find(x)
            py = find(y)
            if px != py:
                uf[px] = py
                res += edge[2]

        return res
