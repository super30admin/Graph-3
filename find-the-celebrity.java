// Time Complexity : O(3N)
// Space Complexity : O(1)

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int potential=0;
        
        for(int i=1;i<n;i++) {
            if(knows(potential, i))
                potential=i;
        }
        
        for(int i=0;i<n;i++) {
            if(i == potential) continue;
            if(!knows(i, potential) || knows(potential, i)) return -1;
        }
        return potential;
    }
}
