"""
Time Complexity : O((v+e) * log(v+e))
Space Complexity : O(n)-nodes  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Here, we have solved this problem using union find. Making a well at a village is considered as drawing a pipe from a dummy village 0.
I that way, we have sorted all our edges, and greedy done union on them to have minimum cost possible.
"""


class Solution:

    def find(self, x):
        if self.uf[x] != x:
            self.uf[x] = self.find(self.uf[x])
        return self.uf[x]

    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        edges, self.uf = [], []
        cost = 0

        for i in range(n+1):
            self.uf.append(i)

        for i in range(n):
            edges.append((wells[i], 0, i+1))

        for pipe in pipes:
            edges.append((pipe[2], pipe[0], pipe[1]))

        edges.sort()

        for edge in edges:
            x = self.find(edge[1])
            y = self.find(edge[2])
            if x != y:
                cost += edge[0]
                self.uf[x] = y
        return cost
