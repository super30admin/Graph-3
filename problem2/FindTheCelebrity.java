// Time Complexity : O(n), n -> Number of people
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class FindTheCelebrity {
	// knows is API call.
	public int findCelebrity(int n) {
		if (n == 0) {
			return -1;
		}

		int celeb = 0;

		for (int i = 1; i < n; i++) {
			if (knows(celeb, i)) {
				celeb = i;
			}
		}

		for (int i = 0; i < n; i++) {
			if (i == celeb) {
				continue;
			}
			if (knows(celeb, i) || !knows(i, celeb)) {
				return -1;
			}
		}

		return celeb;
	}

	public static void main(String[] args) {

	}

}
