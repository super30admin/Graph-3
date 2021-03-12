//Time - O(n)
//Space - O(1)

class Solution {
public:
    int findCelebrity(int n){
        int celeb = 0;
        for(int i = 0;i<n;i++){
            if(knows(celeb,i)){
                celeb = i;
            }
        }
        
        for(int i=0;i<celeb;i++){
            if(knows(celeb,i)) return -1;
        }
        
        for(int i = 0;i<n;i++){
            if(!knows(i,celeb)) return -1;
        }
        
        return celeb;
        
    }
}