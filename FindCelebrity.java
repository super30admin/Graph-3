class Relation {
    boolean knows(int A,int B){
        return true;

    }
}

public class FindCelebrity extends Relation{
    public int celebrity(int n){
        int celeb = n;
        int person = 0;
        for(person =0; person < n; person++){
            if(knows(celeb,person)){
                celeb = person;
            }
        }
        for(person = 0; person < celeb; person++){
            if(person == celeb){
                continue;
            }
            if(knows(celeb,person) || !knows(person,celeb)){
                return -1;
            }
        }
        return celeb;
    }
}
