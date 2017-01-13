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

// Solution 2. With memory.
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict.contains(s)) {
            return true;
        }
        return wordBreakHelper(s, 0, wordDict, new HashMap<Integer, Boolean>());
    }
    private boolean wordBreakHelper(String s, int start, List<String> wordDict, Map<Integer, Boolean> memory) {
        if (start == s.length()) {
            return true;
        }
        if (memory.containsKey(start)) {
            return memory.get(start);
        }
        for (int end = start; end < s.length(); ++end) {
            if (wordDict.contains(s.substring(start, end+1))) {
                boolean matched = wordBreakHelper(s, end+1, wordDict, memory);
                memory.put(end+1, matched);
                if (matched) {
                    return true;
                }
            }
        }
        memory.put(start, false);
        return false;
    }
}
