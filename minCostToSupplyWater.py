class Solution:
    '''
    0,1,2,3
    0,0,0,0
    c = 1+2+2
    0,1,1  0,2,2  0,3,2  1,2,10  2,3,100 
    get all the comb of [ src, des, cost ] 
    sort it by cost
    if the src and des have different parent:
        include the cost
    if the src and des have same parent:
        do not include the cost
    '''

    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        self.uf = [0] * (n+1)
        for i in range(len(self.uf)):
            self.uf[i] = i
            
        edges = []  
        for i in range(1, len(wells)+1):
            edges.append([0, i, wells[i-1]])
        for edge in pipes:
            edges.append(edge)
        
        edges.sort(key = lambda x:x[2])
        # print("edges", edges)
        result = 0
        for edge in edges:
            px = self.find(edge[0]) # find parent of x 
            py = self.find(edge[1]) # find parent of y
            if px != py:
                result += edge[2]
                self.uf[px] = py
        return result
            
    def find(self, x):
        if self.uf[x] != x:
            self.uf[x] = self.find(self.uf[x])
        return self.uf[x]
        
        
# Time Complexity: O[(n+m).log(n+m)]
# Space Complexity: O(n+m)
# where n = number of houses, m = number of pipes



