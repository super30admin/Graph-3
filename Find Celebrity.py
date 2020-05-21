'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation:
For every person a,b check if a knows b this means that b is a potential candidate for being a celebrity, now keep doing
this until we get a potential celebrity. Potential is index

For the potential celebrity got above check if every person a knows potential and potential does not a. If every this is
false then return -1 else return potential
'''


# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        potential = 0
        # gives the potential of the person
        for i in range(1, n):

            if knows(potential, i):
                potential = i
            print(potential)

        for i in range(0, n):
            if i == potential:
                continue

            if knows(potential, i) or not knows(i, potential):
                return -1

        return potential