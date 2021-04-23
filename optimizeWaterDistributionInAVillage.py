# Time Complexity : O(e+eloge)
# Space Complexity : O(Edges)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        self.disjointSet = [0 for i in range(n+1)]
        
        res = 0
        
        for i in range(n+1):
            self.disjointSet[i] = i
        
        edges = []
        
        for i in range(1, n+1):
            edges.append([0,i, wells[i-1]])
        for pipe in pipes:
            edges.append(pipe)
            
        #sort on prices 
        edges = sorted(edges, key = lambda x:x[2])
        
        for edge in edges:
            x = self.find(edge[0])
            y = self.find(edge[1])
            if x != y:
                self.disjointSet[x] = y
                res += edge[2]
        return res
    def find(self, x):
        if  self.disjointSet[x] != x:
            self.disjointSet[x] = self.find(self.disjointSet[x])
            
        return self.disjointSet[x]