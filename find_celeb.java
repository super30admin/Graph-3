// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int findCelebrity(int n){
    int celeb = 0;
    for(int i=1; i< n; i++){
        if(knows(celeb,i)){
            celeb = i;
        }
    }

    for(int i=0; i< n; i++){
        if(i!= celeb){
            if(knows(celeb, i) || !knows(i, celeb)){
                return -1;
            }
        }
    }
    return celeb;
}