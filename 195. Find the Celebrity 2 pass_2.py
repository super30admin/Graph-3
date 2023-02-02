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
        # current potential celebrity
        celeb = 0
        # First pass
        # we check if our current potential celebrity knows someone or not
        # if it does know someone then that person becomes the potential celebrity
        for i in range(n):
            if Celebrity.knows(celeb, i):
                celeb = i
        # 2nd pass
        # we check if the current potential celebrity does not knows the people behind
        # the people behind knows the celebrity
        # and also if the people ahead knows the potential celebrity as we didn't check it in the 1st pass
        for i in range(n):
            if celeb == i:
                continue
            # if i less than celeb
            elif i < celeb:
                if Celebrity.knows(celeb, i) or not Celebrity.knows(i, celeb):
                    return -1
            # check for i greater than celeb, if they know celeb or not
            # if not we return -1
            else:
                if not Celebrity.knows(i, celeb):
                    return -1

        return celeb

# Graph, 2 pass
# Time Complexity :O(n). It's O(2n) but 2 is constant so it's O(n)
# Space Complexity: O(1). No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

