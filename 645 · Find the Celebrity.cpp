/*
Time: O(n)
Space: O(1)

2 pass:
1st pass: eliminate all but one candidates who can not be the celebrity
2nd pass: validate if the remaining candidate knows no one and everyone knows him
*/


// Forward declaration of the knows API.


bool knows(int a, int b);

class Solution {
public:
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */

    int findCelebrity(int n) {
        int candidate = 0;

        for(int i=1;i<n;i++){
            if(knows(candidate, i))
                candidate = i;
        }

        for(int i=0;i<n;i++){
            if(i == candidate)  continue;
            if(knows(candidate, i) == true || knows(i, candidate) == false)  return -1;
        }

        return candidate;
        // Write your code here
    }
};
