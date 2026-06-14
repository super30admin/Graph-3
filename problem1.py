# problem 1
import heapq
class Solution:
    def minCostToSupplyWater(self, n, wells, pipes):
        # get all edge 
        my_map = defaultdict(list)
        for idx,cost in enumerate(wells):
            my_map[0].append((cost,idx+1))
        
        for a,b,cost in pipes:
            my_map[a].append((cost,b))
            my_map[b].append((cost,a))

        span_set = set([0])
        heapq.heapify(my_map[0])
        edges_heap = my_map[0]
        min_cost = 0 
        while len(span_set) < n+1:
            cost, next_house = heapq.heappop(edges_heap)
            if next_house not in span_set:
                span_set.add(next_house)
                min_cost += cost
                for new_cost, neighbor_house in my_map[next_house]:
                    if neighbor_house not in span_set:
                        heapq.heappush(edges_heap, (new_cost, neighbor_house))
        return min_cost 
