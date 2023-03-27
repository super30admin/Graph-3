public class Solution extends Relation {
    public int findCelebrity(int n) {
    int start = 0;   
    int end = n-1;  
    while(start<end){
        if(knows(start,end)) {
            start++;
        }
        else end--;
        } 
    for(int i=0;i<n;i++){
        if(start!=i && (knows(start,i) || !knows(i,start))) return -1;
    }
    return start;
    }
}