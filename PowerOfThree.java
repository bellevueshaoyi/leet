// https://leetcode.com/articles/power-of-three/#approach-3-mathematics-accepted
// 主要涉及如何比较两个double,以及如何判断一个double是否为整数。
public class Solution {
    public boolean isPowerOfThree(int n) {
        double a = Math.log10(n) / Math.log10(3);
        // 这个可以判断一个double是否为整数。
        return a == Math.floor(a) && !Double.isInfinite(a);
    }
}
