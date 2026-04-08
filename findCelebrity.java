// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA  
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1pass - check celeb with all elements of n-1 , if celeb knows i, update celeb to i
// move forward till celeb does not know anyone 
// 2pass => check the found celeb is correct => celeb knows no one, everyone knows celeb

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindCelebrity extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        for (int i = 1; i < n; i++)
            if (knows(celeb, i))
                celeb = i;

        for (int i = 0; i < n; i++) {
            if (celeb == i)
                continue;
            if (knows(celeb, i) || !knows(i, celeb))
                return -1;
        }

        return celeb;
    }
}