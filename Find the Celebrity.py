# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        #Brute Force Approach
        # Time O(n**2)
        # Space O(n)
        # arr = [0 for i in range(n)]
        # for i in range(n):
        #     for j in range(n):
        #         if i!=j:
        #             if knows(j,i): arr[i] += 1
        #             if knows(i,j):
        #                 arr[i] -= 1
        #                 break
        # # print(arr)
        # for i in range(len(arr)):
        #     if arr[i] == n-1: return i
        # return -1

        # Optimal Approach
        # Time O(n)
        # Space O(1)
        celeb = 0
        for i in range(1,n):
            if knows(celeb, i): celeb = i
        # print(celeb)
        for i in range(n):
            if i==celeb: continue
            if not knows(i, celeb) or knows(celeb, i): return -1
        return celeb