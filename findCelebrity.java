
// Time Complexity : (n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
/*
 * We create an indegrees array based on known and knows , by the end, if a person has n-1 indegree value, he is the celebrity
 */

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */


public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] indegrees = new int[n] ;
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( i != j ) {
                    if ( knows(i,j) ) { //i knows j
                        indegrees[i]-- ; //knows a person
                        indegrees[j]++ ; //known by a person
                    }
                }
            } 
        }
        
        for ( int i = 0; i < n; i++ ) {
            if ( indegrees[i] == n-1 ) return i ;   //if known by n-1 people, he is the celebrity
        }
        
        return -1;
    }
}