from typing import List


class Solution:
    class Node:
        def __init__(self):
            self.data = None
            self.parent = None
            self.rank = None

    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        """
            'n' is the number of houses
        """

        self._make_set(n)

        # Kruskal
        q = []  # list of all edges
        for u, v, w in pipes:
            q.append((w, u, v))
        for i, cost in enumerate(wells):
            q.append((cost, 0, i + 1))
        q.sort(key=lambda x: x[0])

        cost = count = 0
        for w, u, v in q:
            # u and v are the vertices (u,v) is the edge
            rA, rB = self._find(self.uf[u]), self._find(self.uf[v])
            # both have the same parent, so they are in the same group
            # do nothing
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

    def _make_set(self, n):
        self.uf = {}
        for i in range(n + 1):
            node = self.Node()
            node.parent = node
            node.rank = 0
            node.data = i
            self.uf[i] = node

    # path compression
    def _find(self, node):
        if node != node.parent:
            node.parent = self._find(node.parent)
        return node.parent

    # union by rank
    def _union(self, parent1, parent2):
        # else whoever's rank is higher becomes parent of other
        if parent1.rank > parent2.rank:
            parent2.parent = parent1
        elif parent2.rank > parent1.rank:
            parent1.parent = parent2
        else:
            # both have same rank but different parent
            parent1.rank = parent1.rank + 1
            parent2.parent = parent1


if __name__ == '__main__':
    print(Solution().minCostToSupplyWater(3, [1, 2, 2], [[1, 2, 1], [2, 3, 1]]))
