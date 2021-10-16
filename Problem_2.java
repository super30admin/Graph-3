public class Solution extends Relation{
    public int findCelebrity(int n){
        int celeb = 0;
        for (int i=1; i<n; i++){
            if (knows(celeb, i)){
                celeb = i;
            }
        }
        // potential celeb
        for (int i = 0; i < n; i++){
            if (i == celeb) continue;
            if (i < celeb){
                if (!knows(i, celeb) || knows(celeb, i)) return -1;
            } else{
                if (!knows(i, celeb)) return -1;
            }
        }
        return celeb;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)