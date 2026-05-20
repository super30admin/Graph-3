

/**
 * Uses a two-pass elimination approach to first find a potential celebrity candidate,
 * then verifies whether everyone knows the candidate and the candidate knows nobody.
 * Time Complexity: O(n), Space Complexity: O(1).
 */
public class Celebrity extends Relation {

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n ; i++) {
            if(knows(candidate,i)) {
                candidate = i;
            }
        }

        for(int i = 0; i < n ; i++) {
            if(candidate == i) continue;

            if(knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }
}
