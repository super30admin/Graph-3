# TIME COMPLEXITY: O(n)
# SPACE COMPLEXITY : O(1)
# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
# def knows(a, b):

class Solution(object):
    def findCelebrity(self, n):
        """
        :type n: int
        :rtype: int
        """
        candidate = 0
        for i in range(1, n):
            # Ask if the candidate knows the next potential candidate
            if knows(candidate, i):
                # If true, candidate knows i, therefore current candidate is not a celebrity - A celebrity knows NOONE!
                # Let's update our candidate to i
                candidate = i

        # Now, i is the potential candidate, check if i is the celebrity
        if self.isCelebrity(candidate, n):
            return candidate
        return -1

    def isCelebrity(self, candidate, n):
        for j in range(n):
            # If j is the candidate
            if j == candidate:
                continue
            # If the candidate knows anyone else or someone does not know the candidate, return False
            if knows(candidate, j) or not knows(j, candidate):
                return False
        return True
