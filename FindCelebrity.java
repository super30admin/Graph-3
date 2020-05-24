//Time Complexity : O(N^2) for Brute Force,O(N) for Logical Deduction 
//Space Complexity : O(1) for Both Approaches
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
 * Approach-1 (Brute Force)
 * As per the problem statement, for a given person i, we can check whether or not i is a celebrity by using the knows(...) API to see if everybody knows i, and that i know nobody.
	Therefore, the simplest way of solving this problem is to go through each of the people in turn, and check whether or not they are a celebrity.
*
* Approach-2 (Logical Deduction)
* The following algorithm can, therefore, be used to rule out n - 1 of the people in O(n) time. 
* We start by guessing that 0 might be a celebrityCandidate, and then we check if 0 knows 1 (within the loop). If true, then we know 0 isn't a celebrity (they know somebody), 
* but 1 might be. We update the celebrityCandidate variable to 1 to reflect this.
* We keep repeating the above process until all persons have been explored
* At the end, the only person we haven't ruled out is in the celebrityCandidate variable
* 
* To verify person is the celebrity,we are gone check the candidate,whether it is known by anyone.
* If anyone know celebrity ,there is no celebrity among given people and we return -1
* else we return celebrity 
* 
*/

class Relation {
	boolean knows(int A, int B) {
		return true;

	}
}

public class FindCelebrity extends Relation {
	public int celebrity(int n) {
		int celeb = n;
		int person = 0;
		for (person = 0; person < n; person++) {
			if (knows(celeb, person)) {
				celeb = person;
			}
		}
		for (person = 0; person < celeb; person++) {
			if (person == celeb) {
				continue;
			}
			if (knows(celeb, person) || !knows(person, celeb)) {
				return -1;
			}
		}
		return celeb;
	}
}
