/* The Knows API is defined in the parent class Relation.
      bool Knows(int a, int b); */

public class Solution : Relation {

    // TC => O(n)
    // SC => O(1)
    public int FindCelebrity(int n){
        if(n <= 1)
        {
            return -1;
        }
        int celeb = 0;

       for(int i = 0; i< n; i++){
        if(i != celeb && Knows(celeb, i)){
            celeb = i;
        }
       }

        for(int k = 0; k < n; k++){
            if(k != celeb && (!Knows(k, celeb) || Knows(celeb, k))){
               return -1;
            }
        }

        return celeb;
    }

    // TC => O(n^2)
    // SC => O(n)
    public int FindCelebrity1(int n) {
        if(n <= 1)
        {
            return -1;
        }
        int[] relations = new int[n];

        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                if(Knows(i, j)){
                    relations[i]--;
                    relations[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(relations[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}