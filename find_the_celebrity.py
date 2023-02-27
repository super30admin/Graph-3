# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        ## T.C = O(n)
        ## S.C = O(1)
        
        celeb = 0
        for i in range(n):
            if i != celeb:
                if knows(celeb, i):
                    celeb = i
        
        print(celeb)
        for i in range(n):
            if i != celeb:
                if knows(celeb, i) or (not knows(i, celeb)):
                    return -1
        
        return celeb

        # in_degrees = [0]*n
        # for i in range(n):
        #     for j in range(n):
        #         if i != j and knows(i, j):
        #             in_degrees[j] += 1
        #             in_degrees[i] -= 1
        
        # for i in range(n):
        #     if in_degrees[i] == n-1:
        #         return i
        # return -1

