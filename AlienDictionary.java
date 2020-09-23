// Time Complexity : O(C) --> where C is n * m in which n is the length of input string array and m is the average length of each word
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (269): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int indegree[];
    Map<Character, Set<Character>> map;
    public String alienOrder(String[] words) {
        indegree = new int[26];
        map = new HashMap<>();
        
        // build the graph
        buildGraph(words);
        
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        // bfs
        for (char c : map.keySet()) {
            if (indegree[c - 'a'] == 0) q.add(c);
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            // iterate on the edges of c
            for (char e : map.get(c)) {
                indegree[e - 'a']--;
                if (indegree[e - 'a'] == 0) q.add(e);
            }
        }
        
        if (map.size() != result.length()) return "";
        return result.toString();
    }
    
    private void buildGraph(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) map.put(c, new HashSet<>());
            }
        }
        
        // based on comparision determine edges
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i]; String second = words[i+1];
            int m = first.length(); int n = second.length();
            // edge case
            if (m > n && first.startsWith(second)) map.clear();
            for (int j = 0; j < m && j < n; j++) {
                char out = first.charAt(j); char in = second.charAt(j);
                if (out != in) {
                    if (!map.get(out).contains(in)) {
                        indegree[in - 'a']++;
                        map.get(out).add(in);
                    }
                    break;
                }
            }
        }
    }
}