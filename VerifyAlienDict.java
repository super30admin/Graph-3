// 953.
// time - O(length of words * avg length of word in words[])
// sapce - constant
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //edge
        if(words == null || words.length == 0)
        {
            return true; //empty words list
        }
        
        //build prority of letters in alien language into an array
        int[] priority = new int[26];
        for(int i = 0; i < order.length(); i++)
        {
            char current = order.charAt(i);
            priority[current - 'a'] = i;
        }
        
        //compare in pairs
        //words[i] < words[i + 1] for all i from 0 to words.length - 1
        for(int i = 0; i < words.length - 1; i++)
        {
            if(!inOrder(words[i], words[i + 1], priority))
            {
                return false;
            }
        }
        
        return true;
    }
    
    //given two words s1 and s2, return true if s1 < s2 i.e. s1 comes before s2 in alphabetical order
    //time - O(min(length of s1, length of s2))
    private boolean inOrder(String s1, String s2, int[] priority) {
        //find the earliest index at which characters in s1 and s2 are not same
        //if charAts1onThatIndex < charAts2onThatIndex return true
        for(int i = 0; i < s1.length() && i < s2.length(); i++)
        {
            char s1Letter = s1.charAt(i);
            char s2Letter = s2.charAt(i);
            if(s1Letter != s2Letter)
            {
                if(priority[s1Letter - 'a'] < priority[s2Letter - 'a'])
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        //edge : s1 = app, s2 = apple
        if(s1.length() < s2.length())
        {
            return true;
        }
        return false;
    }
}
