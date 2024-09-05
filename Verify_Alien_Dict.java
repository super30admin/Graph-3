// Time Complexity : O(n*k)/ k Avg word length
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();

        for(int i=0; i< order.length(); i++){
            map.put(order.charAt(i), i);
        }

        for(int i =0; i< words.length-1; i++){
            String first = words[i];
            String second = words[i+1];
            if(isNotSorted(first, second)){
                return false;
            }
        }
        return true;
    }

    private boolean isNotSorted(String first, String second){
        int m = first.length();
        int n = second.length();

        for(int i = 0; i< m && i < n; i++){
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(i);
            if(firstChar != secondChar){
                return map.get(firstChar) > map.get(secondChar);
            }
        }
        return m > n;
    }
}