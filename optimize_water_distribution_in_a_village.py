class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        ## T.C = O((n+m).log(n+m))
        ## S.C = O(n+m)


        def find_parent(x):
            if union_find[x] != x:
                union_find[x] = find_parent(union_find[x])

            return union_find[x]

        edges = []
        union_find = [i for i in range(n+1)]
        total = 0
        print(union_find)

        for i in range(0, len(wells)):
            edges.append([0, i+1, wells[i]])
        
        edges = edges + pipes

        edges.sort(key=lambda x : x[2])

        for edge in edges:
            x, y, cost = edge
            px = find_parent(x)
            py = find_parent(y)

            if px != py:
                union_find[px] = py
                total = total + cost
            
        return total
