// https://leetcode.com/problems/patching-array/.
// This one is very tricky... See https://leetcode.com/articles/patching-array/.
// The biggest takeaway is to use "long upBound" instead of "int upBound" to avoid integer overflow.

public class Solution {
    public int minPatches(int[] nums, int n) {
        if (n <= 0) {
            return 0;
        }
        int patches = 0;
        // upBound is exclusive [k, upBould).
        // Bug #1: use upBound here to avoid integer overflow.
        long upBound = 1;
        int i=0;
        // bug #2: forgot upBound<=n!! 
        while (i<nums.length && upBound <= n) {
            if (nums[i] <= upBound) {
                upBound += nums[i];
                // bug #3: do NOT increment i if the number at position i is bigger than upBound, which means we have to add a new number to the array.
                ++i;
            } else {
                ++patches;
                upBound *= 2;
            }
        }
        while (upBound <= n) {
            ++patches;
            upBound *= 2;
        }
        return patches;
    }
}
