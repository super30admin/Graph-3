"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        ptnlCand = 0

        for i in range(1, n):
            if knows(ptnlCand, i):
                ptnlCand = i

        for i in range(n):
            if i == ptnlCand:
                continue
            if i < ptnlCand:
                if knows(ptnlCand, i) or not knows(i, ptnlCand):
                    return -1
            else:
                if not knows(i, ptnlCand):
                    return -1

        return ptnlCand 