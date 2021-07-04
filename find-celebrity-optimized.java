/*

https://leetcode.com/problems/find-the-celebrity/
Did it run on leetcode: yes
Did you face any problem : No

Time Complexity: 0(N)
Space Complexity: 0(1)

Algorithm:

- With first iteration , find a possible celebrity
- with second iteration, check if he is a actual celebrity


*/


/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int celeb = 0;
            for(int people =0;people<n;++people){
                if(knows(celeb,people)){
                    celeb = people;
                }
            }
            
            for(int people=0;people<n;++people){
                if(celeb == people){ continue; }
                if(knows(celeb,people) || !knows(people,celeb)){
                    return -1;
                }
            }
            return celeb;
        }
    }