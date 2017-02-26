
// https://leetcode.com/problems/jump-game/?tab=Description.
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Show Company Tags
Show Tags

*/

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return true;
        }
        int index=0;
        int move = 0;
        while (index < nums.length) {
            --move;
            move = Math.max(move, nums[index++]);
            if (move == 0) {
                break;
            }
        }
        return index == nums.length;
    }
}
