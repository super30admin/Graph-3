from typing import List
class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        edges = []
        parent = [i for i in range(n+1)]
        for pipe in pipes:
            edges.append(pipe)
        
        for i in range(n+1):
            edges.append([0,i,wells[i-1]])
        result =0
        def findparent(x):
            if parent[x]!=x:
                parent[x] = findparent(parent[x])
            return parent[x]
        edges.sort(key=lambda x:x[2])
        for edge in edges:
            x,y = edge[0],edge[1]
            px = findparent(x)
            py = findparent(y)
            if px!=py:
                result+=edge[2]
                parent[py] = px
        return result


        
        