/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        
        //forward pass
        for(int i=0; i<n; i++){ // T.C - o(N)  S.C - O(1)
            if(knows(celeb, i)){
                celeb = i;
            }
        }
        
        //backward pass
        for(int i=n-1; i>=0; i--){
            if(i != celeb){
                if(!knows(i, celeb) || knows(celeb, i))  // either if any one doesnt know celebrity or celebrity knows any one, return -1
                    return -1;
            }
        }
        
        return celeb;
    }
}
