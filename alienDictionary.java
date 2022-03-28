// Time Complexity = O(nk) where n=no. of words, k=avg size of each word
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We have a hashmap to store the adjacency list
// indegrees array to count the number of incoming edges to each character
// create a graph out of it and do a bfs on it, use a string builder to store the result

class Solution {
    int[] indegrees;
    HashMap<Character, List<Character>> map;

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        indegrees = new int[26];
        map = new HashMap<>();

        buildGraph(words);

        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char key: map.keySet()) {
            if(indegrees[key-'a'] == 0) {   // these characters are the first in line since they dont have anyone above them (indegree == 0)
                q.add(key);
                sb.append(key);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            char c = q.poll();
            List<Character> list = map.get(c);
            if (list != null) {
                for (char k: list) {
                    indegrees[k-'a']--;
                    if (indegrees[k-'a'] == 0)  {
                        q.add(k);
                        sb.append(k);
                    }
                }
            }
        }

        if (map.size() != sb.length()) return "";   // there might be some elements in the map that dont have indegree == 0, so they wont be added to the sb

        return sb.toString();
    }

    // we will update the indegrees array and map by traversing the words
    private void buildGraph(String[] words) {
        for (String word: words) {
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
            }
        }

        for (int i=0; i<words.length-1; i++) {
            String first = words[i];
            String second = words[i+1];

            int m = first.length();
            int n = second.length();
            if (m > n && first.startsWith(second)) {
                map.clear();
                break;
            }

            for (int j=0; j<m && j<n; j++) {
                char f = first.charAt(j);
                char s = second.charAt(j);
                if (f != s) {
                    map.get(f).add(s);
                    indegrees[s-'a']++;
                    break;                  // we need to break here since we found a mismatch
                }
            }
        }
    }
}