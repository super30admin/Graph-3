/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class FindCelebrity {
    /**
     * optimized solution.
     take a variable and assign first element as celebrity..
     iterate through and check if celeb knows anyone, if so reassign celeb.

     at the end of first pass we will have a celeb.
     to confirm this, go through another pass and confirm if celeb is indeed the one by check with elements less than celeb in both direction(celeb should not know element and element should know celeb). if either one happens return -1.
     if we get out of for loop at the end without hitting -1., we have celeb.
     *
     * Time - o(2n) - o(n)
     Space - o(1)
     */
    public int findCelebrity2(int n) {
        if (n == 0) {
            return -1;
        }
        int celeb = 0;
        // first pass
        for (int i = 0; i < n; i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }
        // second pass to check for all the connections before the current celeb.
        for (int i = 0; i < n; i++) {
            if (i != celeb) {
                if (!knows(i, celeb) || knows(celeb, i)) {
                    return -1;
                }
            }
        }
        return celeb;
    }






    /**
     * brute force. go through each element in array and check if other person knows using knows api.
     * Time complexity - o(n2)
     * Space Complexity =0(n)
     */

    boolean knows(int a, int b) {
        return false;
    }

    public int findCelebrity(int n) {
        if (n == 0) {
            return -1;
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (knows(i, j)) {
                        indegree[i]--;
                        indegree[j]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
