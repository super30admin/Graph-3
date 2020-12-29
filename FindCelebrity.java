// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// when we do 1 check knows(A, B)
// if true: A is not the celebrity, if false: B is not the celebrity
// do n-1 checks to find a celebrity candidate, then check if the candidate is known by all and not knows anyone

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        
        for(int i=1; i<n; i++){
            if(knows(celebrityCandidate, i))
                celebrityCandidate = i;
        }
        
        if(isCelebrity(celebrityCandidate, n))
            return celebrityCandidate;
        
        return -1;
    }
    
    private boolean isCelebrity(int i, int n){
        for(int j=0; j<n; j++){
            if(i==j)
                continue;
            
            if(knows(i,j) || !knows(j,i))
                return false;
        }
        
        return true;
    }
}