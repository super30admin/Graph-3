// 269.
// time - O(length of words * avg length of words in words[] + number of charcters in words[])
// space - O(number of charcters in words[]) - map size + queue 
class Solution {
    public String alienOrder(String[] words) {
        //edge
        if(words == null || words.length == 0)
        {
            return "";
        }
        HashMap<Character, Set<Character>> graph = new HashMap<>(); //adjacency list representation of words[]
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);
        
        Queue<Character> support = new LinkedList<>(); //for bfs
        //add all letters with in degree 0 into queue initially
        for(Character letter : graph.keySet())
        {
            if(inDegree[letter - 'a'] == 0)
            {
                support.offer(letter);
            }
        }
        
        StringBuilder result = new StringBuilder(); //return string
        while(!support.isEmpty())
        {
            //add current into string
            Character current = support.poll();
            result.append(current);
            //adjust the indegree of neighbors and push into queue if indegree hits 0
            Set<Character> edges = graph.get(current);
            if(edges != null)
            {
                for(Character neighbor : edges)
                {
                    inDegree[neighbor - 'a']--;
                    if(inDegree[neighbor - 'a'] == 0)
                    {
                        support.offer(neighbor);
                    }
                }
            }
        }
        
        //check if any char has non zero indegree if so return empty string
        for(int i = 0; i < 26; i++)
        {
            if(inDegree[i] != 0)
            {
                return "";
            }
        }
        return result.toString();
    }
    
    //go through each pair of words in words[] and build edges
    //time - O(length of words * avg length of words in words[])
    private void buildGraph(String[] words, HashMap<Character, Set<Character>> graph, int[] inDegree) {
        //create an entry in the graph for all letters in words[]
        for(String word : words)
        {
            for(int i = 0; i < word.length(); i++)
            {
                graph.put(word.charAt(i), new HashSet<>());
            }
        }
        
        //for each pair of words find first different character and build map
        for(int j = 0; j < words.length - 1; j++)
        {
            String word1 = words[j];
            String word2 = words[j + 1];
            if(word1.length() > word2.length() && word1.startsWith(word2)) 
            {
                graph.clear();
            }
            for(int i = 0; i < word1.length() && i < word2.length(); i++)
            {
                if(word1.charAt(i) != word2.charAt(i))
                {
                    char source = word1.charAt(i);
                    char dest = word2.charAt(i);
                    if(graph.get(source).add(dest))
                    {
                        inDegree[dest - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}
