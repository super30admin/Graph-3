class FindCelebrity {

    // Time Complexity: O(2n)
    // Space Complexity: O(1)

    public static int findCelebrity(int n) {
        int curr = 0;
        
        // Select the potential candidate to be celebrity
        for(int i = 1; i < n; i++){
            if(knows(curr, i))
                curr = i;
        }
        
        for(int i = 0; i < n; i++){
            // Check if the candidate does not know anyone and also everyone knows the candidate
            if(i != curr && (knows(curr, i) || !knows(i, curr)))
                return -1;
        }
        
        return curr;
    }
}