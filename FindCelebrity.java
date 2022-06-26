// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Take 0 as initial celebrity, and loop through 1 to n
// If current knows the other, other can be celebrity candidate
// We will reassign the candidate, 
// Once we get the candidate we can check if it knows no one
// and everybody knows him and return -1 if condition doesn't satisfy
// We will return clebrity value if the condition satisfies
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int celebrity = 0;
            for(int i = 1; i < n; i++){
                if(knows(celebrity, i))
                    celebrity = i;
            }
            for(int i = 0; i < n; i++){
                if(i != celebrity){
                    if(!knows(i, celebrity) || knows(celebrity, i))
                        return -1;
                }
            }
            return celebrity;
        }
    }