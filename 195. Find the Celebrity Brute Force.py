"""
The knows API is already defined for you.
@param a, person a
@param b, person b
@return a boolean, whether a knows b
you can call Celebrity.knows(a, b)
"""


class Solution:
    # @param {int} n a party with n people
    # @return {int} the celebrity's label or -1
    def findCelebrity(self, n):
        # Write your code here
        indegrees = [0 for i in range(n)]

        for row in range(n):
            for col in range(n):
                if row == col:
                    continue
                elif Celebrity.knows(row, col):
                    indegrees[row] -= 1
                    indegrees[col] += 1

        for i in range(len(indegrees)):
            if indegrees[i] == n - 1:
                return i
        return -1

# Graph , Brute Force
# Time Complexity :O(n^2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
