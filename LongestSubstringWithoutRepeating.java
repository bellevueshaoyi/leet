//https://leetcode.com/articles/longest-substring-without-repeating-characters/#approach-2-sliding-window-accepted
//一个非常漂亮的写法
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        boolean[] visited = new boolean[256];
        int max = 0;
        int left=0, right = 0;
        while (left < s.length() && right < s.length()) {
            if (visited[s.charAt(right)]) {
                visited[s.charAt(left++)] = false;
            } else {
                visited[s.charAt(right++)] = true;
                max = Math.max(max, right-left);
            }
        }
        return max;
    }
}
