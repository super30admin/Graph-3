// Time Complexity = O(nk), where n = no. of words, k = avg length of each word
// Space Complexity = O(1), map takes 26 characters at most hence constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use a hashMap to store the order of characters
// We traverse the words list 2 words at a time and see if they are in lexicographic order, if not return false
class Solution {
    Map<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) return true;

        map = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            map.put(c, i);
        }

        for (int i=0; i<words.length-1; i++) {
            String first = words[i];
            String second = words[i+1];

            if (isNotSorted(first, second)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotSorted(String first, String second) {
        int m = first.length();
        int n = second.length();

        for (int i=0; i<m && i<n; i++) {
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(i);
            if (firstChar != secondChar) {
                // if the first character index is greater than the second it is not in order
                return map.get(firstChar) > map.get(secondChar);
            }
        }

        // when m>n we know that the words are not in lexographic order. Example = word, wor
        return m>n;
    }
}