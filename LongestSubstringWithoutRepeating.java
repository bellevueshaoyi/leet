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

// 解法二，one pass，这个适合于非常大的stream (也就是当s非常大，不可能全放进内存，需要一个一个字母的读，不希望回头重新读s.char(left).
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int[] position = new int[256];
        // position存放的是每个字母最后一次出现的位置。还没出现过的时候为-1.
        Arrays.fill(position, -1);
        int max = 0;
        for (int left=0, right=0; right<s.length(); ++right) {
            char c = s.charAt(right);
            // 关键是Math.max().  如果只是left = position[c]+1的话，就有可能会把left给移回去了。
            // 比如"abba"，right=3时候，position['a']==0, 如果left = position['a']+1的话，left就等于1了，而实际上这时候left已经在第二个'b'了。
            left = Math.max(left, position[c]+1);
            position[c] = right;
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
