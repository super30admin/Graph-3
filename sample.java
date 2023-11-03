//Problem 1: Distribute water in village
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// check if one village is already in group, if yes dont merge, if no merge and change that village's parent village to merger group parent village.
class Solution {

    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        this.uf= new int[n+1];

        for(int i=0;i<=n;i++){
            uf[i]=i;
        }

        List<int[]> edges= new ArrayList<>();
        for(int i=1;i<=n;i++){
            edges.add(new int[]{0,i, wells[i-1]});
        }

        for(int[] pipe: pipes){
            edges.add(pipe);
        }

        Collections.sort(edges, (a,b)->a[2]-b[2]);
        int res=0;
        for(int[] edge: edges){
            int x=edge[0];
            int y=edge[1];
            int px=unionFind(x);
            int py=unionFind(y);
            if(px!=py){ //if not unionized
                res+=edge[2];
                uf[py]=px;
            }
        }
        return res;
    }

    // private int unionFind(int x){
    //     if(uf[x]!=x){
    //         return unionFind(uf[x]);
    //     }else{
    //         return x;
    //     }
    // }
    private int unionFind(int x){
        if(uf[x]!=x){
            uf[x]= unionFind(uf[x]);
        }
        return uf[x];
    }
}


//Problem 2: Find celebrity
// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// similar as town judge, use indegrees or knows functions and then at the end check if celeb knows anyone or no.

public class Solution extends Relation {
public int findCelebrity(int n) {
  // int[] indeg=new int[n];
  // for(int i=0;i<n;i++){
  //     for(int j=i+1;j<n;j++){
  //         if(knows(i,j)){
  //             indeg[i]--;
  //             indeg[j]++;
  //         }
  //         if(knows(j,i)){
  //             indeg[j]--;
  //             indeg[i]++;
  //         }
  //     }
  // }

  // for(int i=0;i<n;i++){
  //     if(indeg[i]==n-1) return i;
  // }
  // return -1;

  int celeb=0;
  for(int i=1;i<n;i++){
      if(knows(celeb, i)){
          celeb=i;
      }
  }

  for(int i=0;i<n;i++){
      if(i==celeb) continue;
      if(!knows(i,celeb) || knows(celeb,i)) return -1;
  }
  return celeb;
}
}