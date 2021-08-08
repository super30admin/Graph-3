// Time Complexity : O(n) --> where n is the length of input string array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (953): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    Map<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        this.map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            map.put(c, i+1);
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (nonSorted(words[i], words[i+1])) return false;
        }
        return true;
    }
    
    private boolean nonSorted(String first, String second) {
        int m = first.length(); int n = second.length();
        for (int i = 0; i < m && i < n; i++) {
            char fc = first.charAt(i);
            char sc = second.charAt(i);
            if (fc != sc) return map.get(fc) > map.get(sc);
        }
        return m > n;
    }
}