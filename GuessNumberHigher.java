// https://leetcode.com/articles/guess-number-higher-or-lower-ii/#approach-3-using-dp-accepted.
// 1) Dp是用数组长度为一,数组长度为二这样递推的.
// 2) min_max. dp(i,j)= pivots(i,j) + Math.min[pivot+Math.max(dp(i,pivot−1),dp(pivot+1,n))]


public class Solution {
    public int getMoneyAmount(int n) {
        if (n<=0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int len=2; len<=n; ++len) {
            for (int start=0; start+len-1<n; ++start) {
                int end = start+len-1;
                int min = Integer.MAX_VALUE;
                for (int pivot = start; pivot<=end; ++pivot) {
                    int left = pivot - 1 >= start ? dp[start][pivot-1] : 0;
                    int right = pivot+1 <= end? dp[pivot+1][end] : 0;
                    min = Math.min(min, Math.max(left, right) + (pivot+1));
                }
                dp[start][end] = min;
            }
        }
        return dp[0][n-1];
    }
}
