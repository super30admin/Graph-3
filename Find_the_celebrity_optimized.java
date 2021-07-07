
TC: O(n)
SC: O(1)

Runtime: 18 ms, faster than 35.24% of Java online submissions for Find the Celebrity.
Memory Usage: 41.9 MB, less than 89.58% of Java online submissions for Find the Celebrity.

Approach: First start with celeb =0 and people =0. Check whether celeb knows people one by one by going through the array.If curr celeb 
knows someone update the celeb as the curr people as the current people has the chance of becoming the celebrity.Update the celeb to people 
if it knows any people.If it is a celeb it will give False for all other checks with people.

Once found the tentative celeb, make sure everybody knows it and it knows no one.

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int celeb =0;
        
        for(int people =0 ; people< n; people++){
            if(knows(celeb,people)){
                celeb = people;
            }
        }
        
        for(int people =0; people<n; people++){
            if(people == celeb) continue;
            
            if(knows(celeb,people) || !knows(people,celeb)) return -1;
        }
        
        return celeb;
        
        
    }
}
