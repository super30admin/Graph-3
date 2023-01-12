import java.util.Stack;

//Time Compexity: O(n)
//Space Complexity: O(n)
public class Solution extends Relation {
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int celeb = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != celeb && (knows(celeb, i) || !knows(i, celeb))) {
                return -1;
            }
        }
        return celeb;
    }
}