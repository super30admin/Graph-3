class Solution:
    #Solution 1
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        #Approach: Kruskal's/Minimum Spanning Tree using Union-Find // Union-by-rank
        #Time Complexity: 
        #Space Complexity: 
        
        #building the edges; including those for wells from a dummy house '0'
        self.edges = pipes
        for i in range(len(wells)):
            self.edges.append([0, i + 1, wells[i]])
        self.edges.sort(key = lambda x : x[2])
        
        #Kruskal's/MST using Union-Find
        self.makeSet(n + 1)
        
        cost = 0
        for edge in self.edges:
            if self.union(edge[0], edge[1]):
                cost += edge[2]
            if self.components == 1:
                break
                 
        return cost
    
    def makeSet(self, size):
        self.rep = [i for i in range(size)]
        self.rank = [0 for _ in range(size)]
        self.components = size
        
    def find(self, x):
        if self.rep[x] != x:
            #return self.find(self.rep[x])          #no path compression
            self.rep[x] = self.find(self.rep[x])    #path compression
        return self.rep[x]
    
    def union(self, x, y):
        repX, repY = self.find(x), self.find(y)
        
        if repX == repY:
            return False
        elif self.rank[repX] < self.rank[repY]:
            self.rep[repX] = repY
        elif self.rank[repY] < self.rank[repX]:
            self.rep[repY] = repX
        else:   #rank[repY] == rank[repX]
            self.rep[repY] = repX
            self.rank[repX] += 1
        
        self.components -= 1
        return True
        
    #Solution 2
    """
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        #Approach: Kruskal's/Minimum Spanning Tree using Union-Find
        #Time Complexity: 
        #Space Complexity: 
        
        #building the edges; including those for wells from a dummy house '0'
        self.edges = pipes
        for i in range(len(wells)):
            self.edges.append([0, i + 1, wells[i]])
        self.edges.sort(key = lambda x : x[2])
        
        #Kruskal's/MST using Union-Find
        self.makeSet(n + 1)
        
        cost = 0
        for edge in self.edges:
            if self.union(edge[0], edge[1]):
                cost += edge[2]
            if self.components == 1:
                break
                 
        return cost
    
    def makeSet(self, size):
        self.rep = [i for i in range(size)]
        self.components = size
        
    def find(self, x):
        if self.rep[x] != x:
            #return self.find(self.rep[x])          #no path compression
            self.rep[x] = self.find(self.rep[x])    #path compression
        return self.rep[x]
    
    def union(self, x, y):
        repX, repY = self.find(x), self.find(y)
        
        if repX == repY:
            return False
        
        self.rep[repY] = repX
        self.components -= 1
        return True
    """