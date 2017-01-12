// https://leetcode.com/articles/minimum-moves-to-equal-array-elements/
// Notes: some solutions may run into integer overflow.

// Solution 1. brute force.
public class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        while(true) {
            int min = nums[0], max = nums[0], max_index = 0; 
            for (int i=0; i<nums.length; ++i) {
                min = Math.min(nums[i], min);
                max_index = nums[i] > max ? i : max_index;
                max = Math.max(nums[i], max);
                
            }
            if (min == max) {
                return count;
            }
            count += max-min;
            for (int i=0; i<nums.length; ++i) {
                if (i != max_index) {
                    nums[i] += (max-min);
                }
            }
        }
    }
}

// Solution 2.  Sort.
public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }
}

// Solution 3. Math.  !!!! Can run into integer overflow!!!
public class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        return moves - min * nums.length;
    }
}

// Solution 4. Math. no integer overflow.
public class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }
}
