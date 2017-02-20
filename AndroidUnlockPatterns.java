// https://leetcode.com/submissions/detail/93608674/.
// https://leetcode.com/articles/android-unlock-patterns/.

// 要记得对角线有两条：左上右下和右上左下。
public class Solution {
    private int minKeys;
    private int maxKeys;
    private int count;
    private static final int DIMENSION = 3;
    public int numberOfPatterns(int m, int n) {
        if (m > n || n <= 0) {
            return 0;
        }
        minKeys = m;
        maxKeys = n;
        count = 0;
        for (int i=0; i<Solution.DIMENSION; ++i) {
            for (int j=0; j<Solution.DIMENSION; ++j) {
                boolean[][] visited = new boolean[Solution.DIMENSION][Solution.DIMENSION];                
                move(i, j, 1, visited);
            }
        }
        return count;
    }
    private void move(int row, int col, int totalKeys, boolean[][] visited) {
        if (row < 0 || row >=Solution.DIMENSION || col < 0 || col >= Solution.DIMENSION || visited[row][col]) {
            return;
        }
        if (totalKeys == maxKeys) {
            ++count;
            return;
        } else if (totalKeys >= minKeys) {
            ++count;
        }
        visited[row][col] = true;
        for (int i=0; i<Solution.DIMENSION; ++i) {
            for (int j=0; j<Solution.DIMENSION; ++j) {
                if (canMove(row, col, i, j, visited)) {
                    // can move.
                    //int a = row*3+col+1;
                    //int b = i*3+j+1;
                    //System.out.println(a+" to " + b);
                    move(i, j, totalKeys+1, visited);
                    // reset.
                    visited[i][j] = false;
                }
            }
        }
    }
    
    private boolean canMove(int startRow, int startCol, int endRow, int endCol, boolean[][] visited) {
        if (visited[endRow][endCol] == true) {
            return false;
        }
        if (endRow==startRow && endCol-startCol==2) {
            return visited[startRow][startCol+1];
        } else if (endRow==startRow && endCol-startCol==-2) {
            return visited[startRow][startCol-1];
        } else if (endRow-startRow==2 && endCol==startCol) {
            return visited[startRow+1][startCol];
        } else if (endRow-startRow==-2 && endCol==startCol) {
            return visited[startRow-1][startCol];
        } else if (endRow-startRow==2 && endCol-startCol==2) {
            return visited[startRow+1][startCol+1];
        } else if (endRow-startRow==-2 && endCol-startCol==-2) {
            return visited[startRow-1][startCol-1];
        } else if (endRow-startRow==-2 && endCol-startCol==2) {
            // !!! 一开始忘了右上左下!!
            return visited[startRow-1][startCol+1];
        } else if (endRow-startRow==2 && endCol-startCol==-2) {
            return visited[startRow+1][startCol-1];
        } else {
            return true;
        }
    }
}
