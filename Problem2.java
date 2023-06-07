/*
Find Celebrity
approach: same as finding the town judge using nested iterations, indegrees array.
here, we can do using nested iterations, but if we observe closely, if a knows b then a is surely not a celebrity
using this we have to find probable celebrity and then check if prob celeb does not know any one and known by all
time: O(n)
space: O(1)
 */
public class Problem2 {
    public int findCelebrity(int n) {
        int celeb = 0;
        for (int i=1;i<n;i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        for (int i=0;i<n;i++) {
            if (celeb!=i && (knows(celeb, i) || !knows(i, celeb))) {
                return -1;
            }
        }
        return celeb;
    }

    private boolean knows(int celeb, int i) {
        return false;
    }
}
