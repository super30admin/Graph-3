class Sample{
    /***********PROBLEM-1***********/

    /***********PROBLEM-2***********/
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//TC:0(N*N)
//SC:0(N)
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int[] incoming=new int[n];
            int[] outgoing=new int[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(knows(i,j)==true){
                        outgoing[i]++;
                        incoming[j]++;
                    }

                }
            }
            for(int i=0;i<n;i++){
                if(incoming[i]==n && outgoing[i]==1){
                    return i;
                }
            }
            return -1;
        }
    }

    /* The knows API is defined in the parent class Relation.
          boolean knows(int a, int b); */
//TC:0(N*N)
//SC:0(N)
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int[] indegree=new int[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(knows(i,j)==true){
                        indegree[i]--;
                        indegree[j]++;
                    }

                }
            }
            for(int i=0;i<n;i++){
                if(indegree[i]==n-1){
                    return i;
                }
            }
            return -1;
        }
    }

    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//TC:0(N)
//SC:0(N)
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            if(n==0){
                return -1;
            }
            int celeb=0;
            for(int i=0;i<n;i++){
                if(i!=celeb){
                    if(knows(celeb,i)){
                        celeb=i;
                    }
                }
            }
            for(int i=0;i<n;i++){
                if(i!=celeb){
                    if(!knows(i,celeb) || knows(celeb,i)){
                        return -1;
                    }
                }
            }
            return celeb;
        }
    }


}