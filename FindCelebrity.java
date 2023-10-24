/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

//Brute force
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class FindCelebrity extends Relation{

    public int findCelebrity(int n) {
        int[] indegrees = new int[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(knows(i,j)){
                    if(i == j) continue;
                    indegrees[i]--;
                    indegrees[j]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(indegrees[i] == n-1) return i;
        }
        return -1;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    public int findCelebrity(int n) {
        int celebrity = 0;
        for(int i=1; i<n; i++){
            if(knows(celebrity,i)){
                celebrity = i;
            }
        }

        for(int i=0; i<n; i++){
            if(i == celebrity) continue;
            if(knows(celebrity,i) || !knows(i,celebrity)) return -1;
        }
        return celebrity;
    }
}
