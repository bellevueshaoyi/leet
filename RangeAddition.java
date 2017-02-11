// https://leetcode.com/articles/range-addition/
// This requires range sum.


public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0) {
            return new int[0];
        }
        int[] output = new int[length];
        for (int i=0; i<updates.length; ++i) {
            int delta = updates[i][2];
            output[updates[i][0]] += delta;
            int next = updates[i][1] + 1;
            if (next < length) {
                output[next] -= delta;
            }
        }
        for (int i=1; i<length; ++i) {
            output[i] += output[i-1];
        }
        return output;
    }
}
