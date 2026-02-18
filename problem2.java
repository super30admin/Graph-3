// TC: O(2n)
//SC:O(1)

class Solution {
    // knows(a,b) is assumed to be provided by the platform.
    // It returns true if person a knows person b.
    boolean knows(int a, int b) {
        // placeholder; platform provides this
        return false;
    }

    public int findCelebrity(int n) {
        int celebrity=0;
        for(int i=1;i<n;i++)
        {
            if(knows(celebrity,i))
            {
                celebrity=i;
            }
        }
        for (int i=0;i<n;i++)
        {
            if(i==celebrity){continue;}
            if(knows(celebrity,i) || !knows(i,celebrity))
            {
                return -1;
            }
        }
        return  celebrity;
    }
}