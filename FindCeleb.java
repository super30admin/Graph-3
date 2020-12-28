// 277.
// time - O(n)
// space - constant
// knows(a, b) => a knows b

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int potentialCelebrity = 0; //assume person 0 as potential celebl
        //for each person from 1 to n - 1, check if that person knows potential celeb and potential celeb doent know that person, if so continue, else make that person as potential celeb
        for(int i = 1; i < n; i++)
        {
            if(knows(i, potentialCelebrity) && !knows(potentialCelebrity, i))
            {
                continue;
            }
            else
            {
                potentialCelebrity = i;
            }
        }
        
        //for all people
        //check if anyone knows potential celeb or potential celeb knows anyone
        //if so there is no celeb else return potential celeb
        for(int i = 0; i < n; i++)
        {
            if(i == potentialCelebrity)
            {
                continue;
            }
            if(!knows(i, potentialCelebrity) || knows(potentialCelebrity, i))
            {
                return -1;
            }
        }
        
        return potentialCelebrity;
    }
}
