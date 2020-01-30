/*

https://leetcode.com/problems/find-the-celebrity/

Did you face any problem: no
Did it run on leet code: Yes
Time Complexity: 0(N^2)
Space Complxity: 0(N^2)

Algorithm:
- Create a matrix of N elements where relation[i][j]==1 defines i knows j
- For an ith person to be a celebrity graph[0...n][i]==1 and graph[i][0...n]=0 and exclude graph[i][i]


*/



/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            
            int[][] celebRelation = new int[n][n];
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    if(i==j){
                        celebRelation[i][j]=1;
                    }else{
                        celebRelation[i][j] = knows(i,j) ? 1:0;
                    }
                }
            }
            
            
            for(int i=0;i<n;++i){
                boolean celeb = true;
                for(int j=0;j<n;++j){
                    
                    if(i==j){ continue; }
                    if(celebRelation[j][i]==1 && celebRelation[i][j]==0){
                        continue;
                    }else{
                        celeb=false;
                        break;
                    }
                }
                
                if(celeb){
                    return i;
                }else{
                    continue;
                }
            }
            
            return -1;
            
            
        }
    }