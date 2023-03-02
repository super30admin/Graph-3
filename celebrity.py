# Time Complexity: O(n)
# Space Complexity: O(1)

# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        indegrees = [0 for i in range(n)]
        for i in range(n):
            for j in range(n):
                if i != j and knows(i, j):
                    indegrees[j] += 1
                    indegrees[i] -= 1
        # print(indegrees)
        for i, val in enumerate(indegrees):
            if val == n-1:
                return i
        return -1
