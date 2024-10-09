// Time Complexity: O(n)
// Space Complexity: O(1)

public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == celeb)
                continue;
            if (i < celeb) {
                if (knows(celeb, i))
                    return -1;
            }
            if (!knows(i, celeb))
                return -1;
        }

        return celeb;
    }
}