# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        cel = 0
        
        for i in range(1, n):
            if knows(cel, i):
                cel = i
                
        for i in range(n):
            if i == cel: #can't know self
                continue
                #know each other
            if not knows(i,cel) or knows(cel, i):
                return -1
            
        return cel