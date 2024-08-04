// TC: O(N)
// SC: O(1)
public class Problem1{
    char[] buf4 = new char[4];
    int buf4Idx=0;
    int buf4Size=0;
    public int read(char[] buf, int n) {
        int index = 0 ;
        while(index<n){
            if(buf4Idx < buf4Size){
                buf[index] = buf4[buf4Idx];
                index++;
                buf4Idx++;
            }else{
                buf4Size = read4(buf4);
                buf4Idx=0;
                if(buf4Size==0) break;
            }
        }

        return index;
    }
}