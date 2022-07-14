class Relation {
    public boolean knows(int a, int b){
        return true;
    }
}
public class FindCelebrity extends Relation{
    // TC : O(n)
    // SC : O(1)
    public int findCelebrity(int n){
        if(n == 0) return -1;

        int celeb = 0; // assuming 0 is celebrity
        for(int i=1; i < n; i++) {
            if(knows(celeb, i)){ // if celeb knows i then as per the rule he is not celebrity
                celeb = i;
            }
        }

        for(int i=0; i < n; i++) {
            if(i < celeb) {
                if(knows(celeb, i) || !knows(i, celeb)) {
                    return -1;
                }
            }else {
                if(!knows(i, celeb)){
                    return -1;
                }
            }
        }
        return celeb;
    }
}
