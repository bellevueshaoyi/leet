//https://leetcode.com/problems/wiggle-subsequence/.
// https://leetcode.com/articles/wiggle-subsequence/

// 1. DP, O(N), O(1) space.

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1) {
            return nums.length;
        }
        int up = 1, down = 1;
        for (int i=1; i<nums.length; ++i) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else if (nums[i] > nums[i-1]) {
                up = down+1;
            } else {
                down = up+1;
            }
        }
        return Math.max(up, down);
    }
}
