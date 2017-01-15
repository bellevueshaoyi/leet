// https://leetcode.com/articles/smallest-rectangle-enclosing-black-pixels/#approach-2-dfs-or-bfs-accepted.

// Had lots of bugs when writing the DFS solution. Remember 1) boundary is "index>=array.length". "index>array.length" is wrong.
// 2) DFS needs a visited array. 3) Use private member vs. function member.

// Solution 1. DFS
public class Solution {
    private int left, right, top, bottom;
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0 || x >= image.length || y >= image[0].length
            || x < 0 || y < 0 || image[x][y] != '1') {
            return 0;
        }
        // One bug here!!!: Used to set "int left=x, right=x;"  Should not redefine top and bottom.
        top=bottom=x;
        left=right=y;
        dfs(image, x, y);
        return (bottom-top) * (right-left);
    }
    private void dfs(char[][] image, int row, int col) {
        // One bug here!!!  Used to check for row > image.length.  Should've checked for row **>=** image.length;
        if (row<0 || row >= image.length || col<0 || col >= image[0].length ||
        image[row][col] != '1') {
            return;
        }
        left = Math.min(left, col);
        top = Math.min(top, row);
        right = Math.max(right, col+1);
        bottom = Math.max(bottom, row+1);
        // Another bug!!! Forgot to mark image[row][col] = '0'. Forgot to use visited[].
        image[row][col] = '0';
        dfs(image, row-1, col);
        dfs(image, row+1, col);
        dfs(image, row, col-1);
        dfs(image, row, col+1);
    }
}

// Solution 2. Brute force (O(N^2))
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0 || x >= image.length || y >= image[0].length
            || x < 0 || y < 0 || image[x][y] != '1') {
            return 0;
        }
        int left=x, top=y, right=x, bottom=y;
        for (int i=0; i<image.length; ++i) {
            for (int j=0; j<image[0].length; ++j) {
                if (image[i][j] == '1') {
                    left = Math.min(left, i);
                    top = Math.min(top, j);
                    right = Math.max(right, i+1);
                    bottom = Math.max(bottom, j+1);
                }
            }
        }
        return (right-left) * (bottom-top);
    }
}
