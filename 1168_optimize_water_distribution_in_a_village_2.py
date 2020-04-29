from typing import List


class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        """
            'n' is the number of houses
        """
        self._make_set(n, pipes, wells)
        self.uf = [i for i in range(n + 1)]
        self.rank = [0 for _ in range(n + 1)]

        # Kruskal
        cost = count = 0
        for w, u, v in self.q:
            # u and v are the vertices (u,v) is the edge
            rA, rB = self._find(u), self._find(v)

            # both found in same group, do nothing
            if rA == rB:
                continue
            self._union(rA, rB)
            # add to the cost
            cost += w
            # Optimize so that we don't traverse all edges
            count += 1
            if count == n:
                return cost
        return cost

    def _make_set(self, n, pipes, wells):
        self.q = []  # list of all edges
        for u, v, w in pipes:
            self.q.append((w, u, v))
        for i, cost in enumerate(wells):
            self.q.append((cost, 0, i + 1))
        self.q.sort(key=lambda x: x[0])

    # path compression
    def _find(self, x):
        if x != self.uf[x]:
            self.uf[x] = self._find(self.uf[x])
        return self.uf[x]

    # union by rank
    def _union(self, x, y):
        if self.rank[x] < self.rank[y]:
            self.uf[x] = y
        elif self.rank[x] > self.rank[y]:
            self.uf[y] = x
        else:
            self.rank[y] += 1
            self.uf[x] = y
