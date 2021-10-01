/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int curr = 0;
        
        for(int i=1; i<n; i++){
            if(knows(curr, i)){
                curr = i;
            }
        }
        
        for(int i=0; i<n; i++){
            if(curr == i){
                continue;
            }
            
            if(knows(curr, i) || !knows(i, curr)){
                return -1;
            }
        }
        
        return curr;
        
    }
}