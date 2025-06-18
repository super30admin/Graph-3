 # T: O(n), S: O(1)

class Solution:
    def findCelebrity(self, n: int) -> int:
       
        candidate = 0
        for i in range(1, n):
            if knows(candidate, i):
                candidate = i

        for i in range(n):
            if i != candidate:
                if knows(candidate, i) or not knows(i, candidate):
                    return -1
        return candidate