// https://leetcode.com/articles/next-permutation/
// Pay attention to test case: [3,5,4,1]. Next permuation is [4,1,3,5], not [5,3,4,1] or not [5, 1,4,3]


public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int pos = -1;
        for (int i=nums.length-1; i>0; --i) {
            if (nums[i] > nums[i-1]) {
                pos = i-1;
                break;
            }
        }
        if (pos != -1) {
            for (int i=nums.length-1; i>pos; --i) {
                if (nums[i] > nums[pos]) {
                    int t = nums[i];
                    nums[i] = nums[pos];
                    nums[pos] = t;
                    break;
                }
            }
        }
        reverse(nums, pos+1);
    }
    void reverse(int[] nums, int start) {
        for (int i=start, j=nums.length-1; i<j; ++i, --j) {
            int t = nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }
    }
}
