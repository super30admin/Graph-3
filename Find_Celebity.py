#Time:O(n)
#Space:O(1)
class Solution:
    def findCelebrity(self, n: int) -> int:
        
        celebrity = 0
        for i in range(n):
            if i == celebrity:
                continue
            if knows(celebrity,i):
                celebrity = i
        
        for i in range(n):
            if i == celebrity:
                continue
            if not knows(i,celebrity) or knows(celebrity,i):
                return -1
        return celebrity