# Time Complexity : O(E log E)
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Treat wells as edges from a virtual node 0 to each house.
# Combine these with pipe edges.
# Run Minimum Spanning Tree using Kruskal's algorithm.

class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        
        parent = list(range(n+1))
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(a,b):
            pa,pb = find(a), find(b)
            if pa == pb:
                return False
            parent[pa] = pb
            return True
        
        edges = []
        
        for i,cost in enumerate(wells):
            edges.append((cost,0,i+1))
        
        for u,v,cost in pipes:
            edges.append((cost,u,v))
        
        edges.sort()
        
        res = 0
        
        for cost,u,v in edges:
            if union(u,v):
                res += cost
        
        return res