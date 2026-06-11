// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We initially assume person 0 is the celebrity and iterate until n persons and call knows API to check if the
assumed celebrity is known to everyone or not. If not known, we update that specific person as celebrity.
Now to check if the updated celebrity is known to the previous persons or if the celebrity knows any of the
previous persons.If so, we return -1, if not, we return that celebrity.
 */


/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for(int i = 0 ; i < n ; i++) {
            if(knows(celebrity , i))
                celebrity = i;
        }
        if(isCelebrity(celebrity, n))
            return celebrity;
        return -1;
    }
    private boolean isCelebrity(int i, int n) {
        for(int j = 0 ; j < n ; j++) {
            if(i == j)
                continue;
            if(knows(i, j) || !knows(j, i))
                return false;
        }
        return true;
    }
}