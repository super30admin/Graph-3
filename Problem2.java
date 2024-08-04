
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
// TC: O(n)
// SC: O(1)
public class Problem2{
    public int findCelebrity(int n) {
        int celeb = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celeb, i))
                celeb = i;
        }

        for (int i = 0; i < n; i++) {
            if (i == celeb)
                continue;
            if (i < celeb) {
                if (knows(celeb, i) || !knows(i, celeb))
                    return -1;
            } else {
                if (!knows(i, celeb))
                    return -1;
            }
        }

        return celeb;
    }
}
