#Apporach
#check the pair of persons and return the knows and store the person who is popular left behind


#Complexities
#Time: O(N)
#Space: O(1)

class Solution:
    def findCelebrity(self, n: int) -> int:
        ans = 0
        for i in range(1, n):
            if knows(ans, i):
                ans = i
        for i in range(n):
            if ans != i:
                if knows(ans, i) or not knows(i, ans):
                    return -1
        return ans