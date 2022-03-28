// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Time Complexity = O(n^2)
// Space Complexity = O(1)
// Approach 1: Using topological sort:
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] inbound = new int[n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(!knows(i, j) || i == j) continue;

                inbound[i]--;
                inbound[j]++;
            }
        }

        for (int i=0; i<n; i++) {
            if (inbound[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}

// --------------------------------------------------------------------------------------------------------------------
// Approach 2:
// Time Complexity = O(n)
// Space Complexity = O(1)
// Approach 2: We identify a potential celebrity in the first pass, and in the second pass we confirm if the person is
// a celebrity of we return -1
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n==0) return 0;

        int celeb = 0;  // lets start with 0 as the celeb
        for (int i=1; i<n; i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        // scan 2, will determine our assumption about the celeb otherwise return -1
        for (int i=0; i<n; i++) {
            if (i != celeb) {
                if (knows(celeb, i) || !knows(i, celeb)) {
                    return -1;
                }
            }
        }
        return celeb;
    }
}
// --------------------------------------------------------------------------------------------------------------------
// Further optimizing on Approach 2:
// We can divide the second scan into 2 parts to decrease the no. of 'knows' calls.
// for numbers greater than celeb, we had already checked if the celeb know the person in the first run,
// in the second run we will just check if they don't know the celeb
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n==0) return 0;

        int celeb = 0;  // lets start with 0 as the celeb
        for (int i=1; i<n; i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        // scan 2, will determine our assumption about the celeb otherwise return -1
        for (int i=0; i<n; i++) {
            if (i != celeb) {
                if (i<celeb) {
                    if (knows(celeb, i) || !knows(i, celeb)) {
                        return -1;
                    }
                }
                else {
                    if (!knows(i, celeb)) {
                        return -1;
                    }
                }
            }
        }
        return celeb;
    }
}