// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        for(int i = 1; i < n; i++){
            if(knows(celeb,i))
                celeb = i;
        }
        for(int i = 0; i < n; i++){
            if(i == celeb)
                continue;
            if(knows(celeb,i) || !knows(i,celeb))
                return -1;
        }
        return celeb;
    }
}