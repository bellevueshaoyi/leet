// https://leetcode.com/articles/longest-valid-parentheses/.
// Two interesting things: 1) stack solution, push -1 as init state, and then pop first from the stack.  
// 2) the O(N) solution, scan from left to right, then from right to left.

// Solution 1. brute force. O(N^3) with stack.
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int i=0; i<s.length(); ++i) {
            for (int j=i+1; j<s.length(); j+=2) {
                if (isValid(s.substring(i, j+1))) {
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
    private boolean isValid(String s) {
        int v=0;
        for (int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') ++v;
            else --v;
            if (v<0) {
                return false;
            }
        }
        return v == 0;
    }
}

// Solution 2. Using stack.  Note that the way it counts length of valid pairs is counter intuitive.
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}

// Solution 3.
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int i=0, start=0, v = 0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++v;
            } else {
                --v;
            }
            if (v == 0) {
                max = Math.max(max, i-start+1);
            } else if (v < 0) {
                v= 0;
                start =i+1;
            }
        }
        for (int i=s.length()-1, start=s.length()-1, v = 0; i>=0; --i) {
            char c = s.charAt(i);
            if (c == ')') {
                ++v;
            } else {
                --v;
            }
            if (v == 0) {
                max = Math.max(max, start-i+1);
            } else if (v < 0) {
                v= 0;
                start =i-1;
            }
        }
        return max;
    }
}
