// https://leetcode.com/articles/word-break/.


// Version 1.  brute force. O(n^n).  !!!Had a bug!!!
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict.contains(s)) {
            return true;
        }
        for (int i=0; i<s.length(); ++i) {
            // had a bug!! Originally wrote ""
            // if (wordDict.contains(s.substring(0,i+1)) {
            //   return wordBreak(s.substring(i+1), wordDict);
            // }
            if (wordDict.contains(s.substring(0,i+1)) && 
                wordBreak(s.substring(i+1), wordDict)) {
                return true;
            }
        }
        return false;
    }
}
