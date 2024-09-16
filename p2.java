// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int celeb = 0;
            //Get the probable celeb
            for(int i=0; i<n; i++){
                if(i != celeb){
                    if(knows(celeb, i)){
                        celeb = i;
                    }
                }
            }
    
            //check if that is actually the celeb
            for(int i=0; i<n; i++){
                if(i != celeb){
                    if(i > celeb){
                        if(!knows(i,celeb)) return -1;
                    }else{
                        if(!knows(i,celeb) || knows(celeb,i)) return -1;
                    }
                    
                }
            }
            return celeb;
        }
    }