# The knows API is already defined for you.
# Returns a boolean, indicating whether person a knows person b.
# def knows(a: int, b: int) -> bool:

class Solution:
    # TC : O(n)
    # SC : O(1)
    def findCelebrity(self, n: int) -> int:
       
        candidate = 0
        
        for i in range(1, n):
            # If the candidate knows person i, then switch candidate to i
            if knows(candidate, i):
                candidate = i

        # Verify candidate is indeed a celebrity
        for i in range(n):
            if candidate != i:
                # Candidate should not know anyone, and everyone should know the candidate
                if knows(candidate, i) or not knows(i, candidate):
                    # If the condition fails, return -1 because there is no celebrity
                    return -1
      
        # If all checks pass, return the candidate as the celebrity
        return candidate