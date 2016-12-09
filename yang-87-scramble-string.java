// Passed LC.  Complexity O(2^N).
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // ***Check both for null***.
        if (s1 == null || s2 == null) {
            return s1 == s2;
        }
        if (s1.equals(s2)) {
            return true;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        int[] letterBuckets = new int[26];
        // ***Use single for loop***.
        for (int i=0; i<s1.length(); ++i) {
            letterBuckets[s1.charAt(i)-'a']++;
            letterBuckets[s2.charAt(i)-'a']--;
        }
        for (int count : letterBuckets) {
            if (count != 0) {
                return false;
            }
        }
        int length = s1.length();
        for (int i=1; i<length; ++i) {
            if (isScramble(s1.substring(0, i), s2.substring(0,i)) && 
                isScramble(s1.substring(i, length), s2.substring(i, length))) {
                    return true;
            } else if (isScramble(s1.substring(0, i), s2.substring(length-i, length)) && 
                    isScramble(s1.substring(i, length), s2.substring(0,length-i))) {
                    return true;
            }
        }
        return false;
    }
}
