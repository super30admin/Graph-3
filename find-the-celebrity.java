// Time, Space - O(N),O(1)
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
              
        if(n < 2) {
            return n;
        }
        
        int celebrity = 0;
        for(int person=0;person<n;person++) {
            if(knows(celebrity, person)) {
                celebrity = person;
            }            
        }
        for(int person=0;person<n;person++) {
            if(person == celebrity) {
                continue;
            }
            if(knows(celebrity, person) || !knows(person, celebrity)) {
                return -1;
            }
        }
        
        return celebrity;
    }
}
