// Approach: Two pass - Logical Deduction (w/o caching)
// Time: O(n)
// Space: O(1)

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Find_The_Celebrity extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;

        for (int i = 1; i<n; i++) {
            if (!knows(i, celebrity)) {
                celebrity = i;      // potential celebrity
            }
        }

        // recheck to connfirm the celebrity
        for (int i = 0; i<n; i++) {
            if (i != celebrity) {       // for any ordinary person i
                if (!knows(i, celebrity) || knows(celebrity, i)) return -1;
            }
        }
        return celebrity;
    }
}

class Relation {
    public boolean knows(int a, int b) {
        return true;
    }
}