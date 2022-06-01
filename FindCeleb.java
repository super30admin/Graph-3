/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// Time Complexity : O(N2)   
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using topological sort
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            if(n==0) return -1;
            
            int[] indegrees = new int[n];
            for(int i =0; i<n; i++){
                for(int j =0; j<n; j++){
                    if(i == j) continue;
                    if(knows(i,j)){
                        indegrees[i]--;
                        indegrees[j]++;
                    }
                }
            }
            for(int i =0; i<n; i++){
                if(indegrees[i] == n-1)
                    return i;
            }
            return -1;
        }
    }

// Time Complexity : O(N)   
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            if(n==0) return -1;
            int celeb =0;
            for(int i =1; i<n; i++){
                if(knows(celeb, i))
                    celeb = i;
            }
            for(int i =0; i<n; i++){
                if(celeb == i) continue;
                if(celeb<i){
                    if(!knows(i, celeb))
                        return -1;
                }
                if(celeb>i){
                    if(knows(celeb, i) || !knows(i, celeb))
                        return -1;
                }
            }
            return celeb;
        }
    }