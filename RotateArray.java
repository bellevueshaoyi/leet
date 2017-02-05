// https://leetcode.com/problems/rotate-array/?tab=Description.
// First reverse the entire array. Then reverse again the top K, then reverse the rest.
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length-k);
    }
    private void reverse(int[] nums, int start, int len) {
        if (len==0) {
            return;
        }
        for (int i=start, j=start+len-1; i<j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
