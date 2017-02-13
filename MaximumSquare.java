// https://leetcode.com/problems/maximal-square/
// Solution 1.
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][][] memory = new int[rows+1][cols+1][3];
        int max = 0;
        for (int i=0; i<rows; ++i) {
            for (int j=0; j<cols; ++j) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                memory[i+1][j+1][0] = memory[i+1][j][0] + 1;
                memory[i+1][j+1][1] = memory[i][j+1][1] + 1;
                memory[i+1][j+1][2] = Math.min(memory[i][j][2] + 1, Math.min(memory[i+1][j+1][0], memory[i+1][j+1][1]));
                max = Math.max(max, memory[i+1][j+1][2]);
            }
        }
        return max*max;
    }
}
