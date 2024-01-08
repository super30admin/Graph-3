// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int[] isCeleb = new int[n];
            for(int i = 0; i < n; ++i)
                isCeleb[i] = 0;
            
            int s = 0;
            int d = 1;
            
            int numNonCel = 0;
            while(d < n)
            {
                if(s == d)
                    d++;
                else
                {
                    boolean hasOutEdge = knows(s,d);
                    if(hasOutEdge == false)
                    {
                        if(isCeleb[d] != 1)
                        {
                            isCeleb[d] = 1;
                            numNonCel++;
                        }
                        d++;
                    }
                    else if ( hasOutEdge == true)
                    {
                        if(isCeleb[s] != 1)
                        {
                            isCeleb[s] = 1;
                            numNonCel++;
                        }
                        s++;
                    }
                }
            }
            int celebNode = -1;
            for(int i = 0; i < n; ++i)
            {
                if(isCeleb[i] == 0)
                {
                    celebNode = i;
                    for(int j = 0; j < n; ++j)
                    {
                        if(j != i && (!knows(j,i) || knows(i,j)))
                            return -1;
                    }
                }
            }
            return celebNode;
        }
    }