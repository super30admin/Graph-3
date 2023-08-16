/* The knows API is defined in the parent class Relation. */
class Relation {
    boolean knows(int a, int b) {
        // Implementation details are not provided in this problem.
        return false;
    }
}

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        
        // Eliminate candidates based on BFS
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        
        // Verify the potential candidate using DFS
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1; // No celebrity found
            }
        }
        
        return candidate;
    }
}

