def findCelebrity(self, n):
    x = 0
    for i in xrange(n):
        if knows(x, i):
            x = i
    if any(knows(x, i) for i in xrange(x)):
        return -1
    if any(not knows(i, x) for i in xrange(n)):
        return -1
    return x

