# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:


class Solution:
    def findCelebrity(self, n: int) -> int:
        # T: O(n), S: O(1)
        # First pass: find the candidate
        candidate = 0
        for i in range(1, n):
            if knows(candidate, i):
                candidate = i

        # Second pass: verify the candidate
        for i in range(n):
            if i != candidate:
                if knows(candidate, i) or not knows(i, candidate):
                    return -1
        return candidate
