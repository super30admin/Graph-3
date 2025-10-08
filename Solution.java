//TC: O(n): one pass to select a candidate (n−1 checks) + one pass to verify (O(n) checks).
//SC: O(1): constant extra variables.

//Pick candidate by scanning i=1..n−1; if candidate knows i, set candidate=i (others can’t be celeb).
//Verify candidate: for every i≠candidate, ensure candidate doesn’t know i and i knows candidate.
//If any verification fails return -1; otherwise return the candidate.

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ptnlCand = 0;

        for(int i = 1; i < n; i++){
            if(knows(ptnlCand, i)){
                ptnlCand = i;
            }
        }

        for(int i = 0; i < n; i++){
            if(i == ptnlCand) continue;
            if(i < ptnlCand){
                if(knows(ptnlCand, i) || !knows(i, ptnlCand)) return -1;
            } else {
                if(!knows(i, ptnlCand)) return -1;
            }
        }

        return ptnlCand;
    }
}
