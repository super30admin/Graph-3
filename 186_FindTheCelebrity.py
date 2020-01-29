'''
time - O(N)
space - O(1)
Approach:
1. iterate through n elements, in first iteration find the celebrity.
2. In the second iteration verify if the found celebrity is actual celebrity or not.
'''
class Solution():
    def findCelebrity(self, n):
        celeb = 0

        for people in range(n):
            if knows(celeb, people):
                celeb = people

        for people in range(n):
            if people == celeb:
                continue;

            if (knows(celeb,people) or not knows(people, celeb)):
                return -1

        return celeb

