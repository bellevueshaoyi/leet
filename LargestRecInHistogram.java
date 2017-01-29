// https://leetcode.com/articles/largest-rectangle-histogram/.
// Remember to put -1 as peek. And the max size is (i-stack.peek()-1).
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i=0; i<heights.length; ++i) {
            while (!stack.empty() && stack.peek() != -1 && heights[stack.peek()] > heights[i] ) {
                int index = stack.pop();
                // !!!! (i - stack.peek() - 1) * heights[index]);
                max = Math.max(max, (i - stack.peek() - 1) * heights[index]);
            }
            stack.push(i);
        }
        int last = stack.peek();
        while (stack.peek() != -1) {
            int index = stack.pop();
            // !!!! (last - stack.peek()) * heights[index]);
            max = Math.max(max, (last - stack.peek()) * heights[index]);
        }
        return max;
    }
}
