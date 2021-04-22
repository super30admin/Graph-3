/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

//TC:O(N)
//SC:O(1)
//Did it run successfully on Leetcode? : Yes
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++)
        {
            // look for requirement 1
            if (knows(candidate, i))
            {
                candidate = i;
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            // Skip the condition of candidate knows himself/herself
            
            if (candidate == i) continue;
            
            // If candidate knows i or i doesn't know candidate, then candidate is not celebrity
            if (knows(candidate,i) || !knows(i, candidate))
                return -1;
        }
        return candidate;
    }
}

