# Approach 
# Time - O(N ^ 2)
# Space - O(N)

def findCelebrity(self, n: int) -> int:
        
    indegrees = [0 for _ in range(n)]
         
    for person1 in range(n):
        for person2 in range(n):
            if knows(person1, person2): # if person1 knows person2, person 1 is not celebrity, so make it negative
                indegrees[person1] -= 1
                indegrees[person2] += 1
                
    for i in range(n):
        if indegrees[i] == n - 1: # if one person knows all except himself
            return i
        
    return -1 # no such person could be determined


# Optimised
# Instead of doing adjacent checks for all such persons
# O(N) Time and O(1) Space


class Solution(object):
    def findCelebrity(self, n):
       
        potential_candidate = 0
        for i in range(1, n):
            # does the potential_candidate candidate know the next candidate
            if knows(candidate, i):
                # If true, candidate knows i, therefore current candidate is not a celebrity 
                # update potential candidate to current one
                candidate = i

        # Now with the potential candidate, check if it is the celebrity
        if self.isCelebrity(candidate, n):
            return candidate
        return -1

    def isCelebrity(self, candidate, n):
        for j in range(n):
            # If j == candidate, dont check with itself continue
            if j == candidate:
                continue
            # If the candidate knows others 
            #  or someone does not know the candidate, return False
            if knows(candidate, j) or not knows(j, candidate):
                return False
        return True