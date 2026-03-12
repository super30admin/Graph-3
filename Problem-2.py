# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# First pass: find potential celebrity.
# If candidate knows someone, candidate cannot be celebrity.
# Second pass: verify candidate.

class Solution:
    def findCelebrity(self, n: int) -> int:
        
        candidate = 0
        
        for i in range(1,n):
            if knows(candidate, i):
                candidate = i
        
        for i in range(n):
            if i != candidate:
                if knows(candidate,i) or not knows(i,candidate):
                    return -1
        
        return candidate