/*
 * The knows API is defined in the parent class Relation.
 * boolean knows(int a, int b);
 */
/*
 * public class Solution extends Relation {
 * public int findCelebrity(int n) {
 * //Tc: O(n) Sc: O(1)
 * int celeb = 0;
 * for (int i = 1; i < n; i++) {
 * if (knows(celeb, i))
 * celeb = i;
 * }
 * 
 * for (int i = 0; i < n; i++) {
 * if (celeb != i) {
 * if (knows(celeb, i) || !knows(i, celeb))
 * return -1;
 * }
 * }
 * 
 * return celeb;
 * }
 * }
 */

/*
 * 
 * 
 * public class Solution extends Relation {
 * public int findCelebrity(int n) {
 * 
 * for(int i = 0; i < n; i++)
 * {
 * boolean isCeleb = true;
 * 
 * for(int j = 0; j < n; j++)
 * {
 * if(i != j)
 * {
 * if(knows(i,j) || !knows(j,i))
 * {
 * isCeleb = false;
 * break;
 * }
 * }
 * }
 * if(isCeleb) return i;
 * }
 * return -1;
 * }
 * }
 */

/*
 * int[] inDegree = new int[n];
 * 
 * for(int i = 0; i < n; i++)
 * {
 * for(int j = 0; j < n; j++)
 * {
 * if(i != j)
 * {
 * if(knows(i,j))
 * {
 * inDegree[j]++;
 * inDegree[i]--;
 * }
 * }
 * }
 * }
 * for(int i = 0; i < n; i++)
 * {
 * if(inDegree[i] == n-1) return i;
 * }
 * return -1;
 * 
 */