# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:


class Solution:
    def findCelebrity(self, n: int) -> int:
        # celebrity=0
        # for i in range(1,n):
        #     if knows(celebrity,i):
        #         celebrity=i
        # for i in range(n):
        #     if i!=celebrity:
        #         if(not knows(i, celebrity) or knows(celebrity, i)):
        #             return -1
        # return celebrity
        cand = 0
        for i in range(1, n):
            if knows(cand, i):
                cand = i
        for i in range(cand, n):
            if not knows(i, cand):
                return -1

        for i in range(cand):
            if not knows(i, cand) or knows(cand, i):
                return -1

        return cand
