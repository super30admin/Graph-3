# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    #Solution 1
    def findCelebrity(self, n: int) -> int:
        #Approach: Candidate search using Two Pointers
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        left, right = 0, n - 1
        while left < right:
            if knows(left, right):
                left += 1
            else:
                right -= 1
                
        for i in range(n):
            if i == left:
                continue
            elif not knows(i, left) or knows(left, i):
                return -1
            
        return left
    
    #Solution 2
    """
    def findCelebrity(self, n: int) -> int:
        #Approach: Candidate search using forward pass
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        candidate = 0
        for i in range(n):
            if knows(candidate, i):
                candidate = i
                
        for i in range(n):
            if i == candidate:
                continue
            elif not knows(i, candidate) or knows(candidate, i):
                return -1
            
        return candidate
    """
    
    #Solution 3
    """
    def findCelebrity(self, n: int) -> int:
        #Approach: Brute Force
        #Time Complexity: O(n^2)
        #Space Complexity: O(n)
        
        netDegrees = [0 for _ in range(n)]
        
        for a in range(n):
            for b in range(n):
                if knows(a, b):
                    netDegrees[a] -= 1
                    netDegrees[b] += 1
                    
        for i in range(n):
            if netDegrees[i] == n - 1:
                return i
            
        return -1
    """