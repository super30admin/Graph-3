# Graph-3

## Problem1: Distribute Water in a Village (https://leetcode.com/problems/optimize-water-distribution-in-a-village/)

## Problem 2:Find Celebrity(https://leetcode.com/problems/find-the-celebrity/)


# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:
# Time Complexity =O(n)
# Space Complexity =O(1)

class Solution:
    def findCelebrity(self, n: int) -> int:
        celeb=0
        for i in range(1,n):
            if knows(celeb,i):
                celeb=i
        for i in range(n):
            if celeb!=i:
                if knows(celeb,i) or not knows(i,celeb):
                    return -1
        return celeb
                
        