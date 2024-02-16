/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
If a knows b a is not a celebrity jump to b. If a doest know b then b is not a celebrity. 
Then for celebrity make sure it is a celebrity by checking all the knows.
*/

#include<iostream>

bool knows(int a,int b); //API

/* The knows API is defined for you.
      bool knows(int a, int b); */

class Solution {
public:
    int findCelebrity(int n) {
        int i{},j{},res{};
        while(j<n){
            if(i==j){
                ++j;
            }
            else{
                if(knows(i,j)){
                    i=j;
                }
                else{
                    ++j;
                }
            }
        }
        res = i;
        for(int i{};i<n;++i){
            if(i == res) continue;
            if(!knows(i,res) || knows(res,i)) return -1;
        }
        return res;
    }
};


