// Took me about 42 minutes. Made several silly mistakes: 
// 1) substring(3) means it starts at index 3 not ends at 3, 
// 2) instead of numPrefixMatched i used boolean prefixMatched, and when inputs are "["dog", "cat", "catdog"]", it failed.
/*
Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

*/

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words.length < 3) {
            return new ArrayList<String>();
        }
        Set<String> set = new HashSet<>();
        for (int i=0; i<words.length; ++i) {
            set.add(words[i]);
        }
        List<String> output = new ArrayList<>();
        for (int i=0; i<words.length; ++i) {
            if (checkForConcats(words[i], 0, set)) {
                set.add(words[i]);
                output.add(words[i]);
            }
        }
        return output;
    }
    
    private boolean checkForConcats(String word, int numPrefixMatched, Set<String> set) {
        if (word.length() == 0) {
            return numPrefixMatched >= 2;
        }
        for (int i=0; i<word.length(); ++i) {
            if (set.contains(word.substring(0, i+1)) && 
                checkForConcats(word.substring(i+1), numPrefixMatched+1, set)) {
                return true;
            }
        }
        return false;
    }
}
