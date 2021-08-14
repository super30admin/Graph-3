/* The knows API is defined for you.
      bool knows(int a, int b); */
/*
/* The knows API is defined for you.
      bool knows(int a, int b); 
//Using indegree Similar to town judge
//Time: O(V^2) where v is the number of people
//Space: O(v)
class Solution {
public:
    int findCelebrity(int n) {
        vector<int> inDegree(n);
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                if(i == j) continue;
                if(knows(i,j)){
                    inDegree[i]--;
                    inDegree[j]++;
                }
            }
        }
        for(int i = 0; i < inDegree.size(); i++){
            if(inDegree[i] == n-1) return i;
        }
        return -1;
    }
};
*/
//Time:O(n)
//Space:O(1) No extra space
class Solution {
public:
    int findCelebrity(int n) {
        int celeb = 0;
        for(int i = 0; i < n;i++){
            if(knows(celeb,i)){
                celeb = i;
            } 
        }
        for(int i = 0; i < n;i++){
            if(i != celeb and (!knows(i,celeb) or knows(celeb,i))) return -1;
        }
        return celeb;
    }
};