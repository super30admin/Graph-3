#Approach
# This uses to find the minimum spanning tree . Have the zero node where well at itself is connected
# find the union algorithm and if it ithe parents are diffrent parent then add to the nodes


#Complexities
#Time: O(m*n)log(M+n)
#Space: O(n)


from typing import List


class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        self.parent = list(range(n+1))
        self.rank = [1]*(n+1)
        for i  in range(len(wells)):
            pipes.append([0,i+1,wells[i]])

        pipes = sorted(pipes, key=lambda x: x[2])

        cost =0
        for houseA,houseB,pipelength in pipes:
            if self.union(houseA,houseB):
                cost+=pipelength
                n-=1
                if n==0:
                    return cost




    def find(self,u):
        parent = self.parent[u]
        if parent != u:
            self.parent[u]=self.find(parent)
        return self.parent[u]

    def union(self,u,v):
        pu,pv = self.find(u),self.find(v)

        if pu==pv:
            return False

        if self.rank[pu]>=self.rank[pv]:
            self.rank[pu]+=1
            self.parent[pv]=pu
        elif self.rank[pv]>self.rank[pu]:
            self.rank[pv]+=1
            self.parent[pu]=pv
        return True




s = Solution()
print(s.minCostToSupplyWater(3,[1,2,2],[[1,2,1],[2,3,1]]))
print(s.minCostToSupplyWater(2,[1,1],[[1,2,1],[1,2,2]]))



