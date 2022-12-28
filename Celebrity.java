// Time Complexity: O(n)
// Space Complexity: O(1)
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n == 0) return -1;
        int celeb = 0;

        for (int i = 1; i < n; i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        for (int i=0; i < n ; i++) {
            if(i != celeb) {
                if (knows(celeb,i) || !knows(i, celeb)) {
                    return -1;
                }
            }
        }

        return celeb;

//         int[] indegrees = new int[n];

//         for(int i = 0; i < n ; i++) {
//             for (int j = 0; j < n; j++) {
//                 if(i != j && knows(i, j)) {
//                     indegrees[j]++;
//                     indegrees[i]--;
//                 }
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             if (indegrees[i] == n-1) {
//                 return i;
//             }
//         }

//         return -1;
    }
}