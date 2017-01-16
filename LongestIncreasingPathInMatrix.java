// https://leetcode.com/articles/longest-increasing-path-matrix/

// DFS with memory
public class Solution {
    // !!!This is a very good way of using array for directions!!!!
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] memory = new int[matrix.length][matrix[0].length];
        /*
        // Do not need to use -1 as init value. This is because each cell should be at least 1 (length of itself). 
        // So 0 is already a good init value.
        for (int[] m : memory) {
            Arrays.fill(m, -1);
        }
        */
        int max = 0;
        for (int i=0; i<matrix.length; ++i) {
            for (int j=0; j<matrix[0].length; ++j) {
                max = Math.max(max, find(matrix, i, j, memory));
            }
        }
        return max;
    }
    
    private int find(int[][] matrix, int row, int col, int[][] memory) {
        if (memory[row][col] >0) {
            return memory[row][col];
        }
        for (int[] dir : dirs) {
            int x = row+dir[0], y = col+dir[1];
            if (x >=0 && x<matrix.length && y>=0 && y<matrix[0].length
                && matrix[x][y] > matrix[row][col]) {
                memory[row][col] = Math.max(memory[row][col], find(matrix, row, col, memory));
            }
        }
        return ++memory[row][col];
    }
}
