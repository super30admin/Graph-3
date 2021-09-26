public class FindCelebrity {


    //Bruteforce
    //For each person check with other person using knows API.
    //TC:O(N^2)
    //SC:O(1)
    public int findCelebrityBruteForce(int n) {
        for(int i=0;i<n;i++) {
            if(isCelebrity(n, i)) {
                return i;
            }
        }
        return -1;
    }
    private boolean isCelebrity(int n, int i) {
        for(int j=0;j<n;j++) {
                if(i==j) continue;
                if(knows(i,j) || !knows(j,i)) {
                    return false;
                }
        }
        return true;
    }


    //Eleminate the not celebrity and hold the possible celebrity in a single pass
    //Check the possible celebrity with other persons.
    //TC:O(N) - O(2N) Where N is number of person.
    //SC:O(1) - As we are not using any extra space.
    public int findCelebrity(int n) {
        int currentCelebrity = 0;
        
        for(int i=0;i<n;i++){
            if(knows(currentCelebrity,i)) {
                currentCelebrity = i;
            }
        }
        if(isC(n, currentCelebrity)) {
            return currentCelebrity;
        }
        return -1;
    }
    
    private boolean isC(int n, int person) {
        for(int i=0;i<n;i++) {
            if(i==person) continue;
            if(knows(person,i) || !knows(i,person)) return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        FindCelebrity findCelebrity = new FindCelebrity();
        int result = findCelebrity.findCelebrity(4);
        System.out.println("The Celebrity is: "+result);
    }
}