# The knows API is already defined for you.
# return a bool, whether a knows b
def knows(a: int, b: int) -> bool:
    pass


class Solution:
    def findCelebrity(self, n: int) -> int:

        # celebrity knows no one
        # knows(celebrity, person) is False
        # find the best suited celebrity (potential)
        celebrity = 0
        for person in range(n):
            # the current celebrity is not the celebrity
            # since he/she knows the current person
            if knows(celebrity, person):
                # update celebrity
                # (may be the current person is the celebrity)
                celebrity = person

        for person in range(n):
            if person == celebrity:
                continue
            # everyone should know the celebrity
            # if even one person does not know the celebrity, he/she is not a celebrity
            # or if the celebrity knows the current person
            if not knows(person, celebrity) or knows(celebrity, person):
                return -1

        return celebrity
