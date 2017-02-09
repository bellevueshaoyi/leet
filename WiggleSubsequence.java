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

// 2. Greedy. O(N).  The logic is not trivial. Had many bugs. Need to consider: 
// 1. [2,2,3,3,4,4]: return 3!
// 2. [2,2,2,2,2]: return 1
// 3. [2,2,3,3,4,3,3,4]: return 4

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1) {
            return nums.length;
        }
        int len = 1;
        // It's a good idea to use prediff instead of a boolean.
        int prediff = 0;
        for (int i=1; i<nums.length; ++i) {
            int diff = nums[i] - nums[i-1];
            if ((diff > 0 && prediff <= 0) || (diff < 0 && prediff >= 0)) {
                ++len;
                prediff = diff;
            }
        }
        return len;
    }
}
