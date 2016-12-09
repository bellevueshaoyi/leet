// Time spent: 1.5 hours on the algorithm.
// Bugs: none.
// There's a much easier solution.
// Spent a few hours on the algorithm. algorithm was initially wrong. this solution is too complex. there's a much easier one.
public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || s.isEmpty() || s.length() < t.length()) {
            return 0;
        }
        int[] lastRow = new int[s.length()];
        int[] currentRow = new int[s.length()];
        // Starts with 1 because first row of DP is treated differently.
        int totalMatches = 1;
        for (int i=0; i<t.length(); ++i) {
            for (int j=0; j<i; ++j) {
                totalMatches += lastRow[j];
            }
            for (int j=i; j<s.length(); ++j) {
                if (t.charAt(i) == s.charAt(j)) {
                    currentRow[j] = totalMatches;
                }
                totalMatches += lastRow[j];
            }
            lastRow = Arrays.copyOf(currentRow, currentRow.length);
            Arrays.fill(currentRow, 0);
            totalMatches = 0;
        }
        int output = 0;
        for (int i=0; i<lastRow.length; ++i) {
            output += lastRow[i];
        }
        return output;
    }
}
