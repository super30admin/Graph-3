// Time Complexity : O(n) --> where n is the given input n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (277): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        for (int person = 0; person < n; person++) {
            if (knows(celeb, person) && !knows(person, celeb)) {
                celeb = person;
            }
        }
        
        for (int person = 0; person < n; person++) {
            if (celeb == person) continue;
            if (!knows(person, celeb) || knows(celeb, person)) return -1;
        }
        
        return celeb;
    }
}