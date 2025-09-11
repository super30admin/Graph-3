# The knows API is already defined for you.
# return a bool, whether a knows b
def knows(a: int, b: int) -> bool:

# class Solution:
#     def findCelebrity(self, n: int) -> int:
#         indegree = [0]*n
#         for i in range(n):
#             for j in range(i+1,n):
#                 if knows(i,j):
#                     indegree[j]+=1
#                     indegree[i]-=1
#                 if knows(j,i):
#                     indegree[i]+=1
#                     indegree[j]-=1
#         for i in range(n):
#             if indegree[i] == n-1:
#                 return i
#         return -1

# class Solution:
#     def findCelebrity(self, n: int) -> int:
#         ptncan = 0
#         for i in range(1,n):
#             if knows(ptncan,i):
#                 ptncan = i
#         for i in range(n):
#             if i == ptncan : continue
#             if knows(ptncan,i) or not knows(i,ptncan): return -1
#         return ptncan


class Solution:
    def findCelebrity(self, n: int) -> int:
        ptncan = 0
        for i in range(1,n):
            if knows(ptncan,i):
                ptncan = i
        for i in range(n):
            if i == ptncan : continue
            if i<ptncan:
                if not knows(i,ptncan) or knows(ptncan,i): return -1
            else:
                if not knows(i,ptncan): return -1
        return ptncan
        
        