// https://leetcode.com/articles/counting-bits/
// Note:  1) set rightmost 1 to 0: x & (x-1);  
// 2) & has higher pri than +. For example, output[3>>1]+ 3&1  is interpreted as (output[3>>1]+3)&1 by compiler!!!!!!

// Solution 1. DP:
public class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] output = new int[num+1];
        for (int i=1; i<=num; ++i) {
            // Note!!!!!  "&" has higher pri than "+"! 
            // So output[3>>1]+ 3&1  is interpreted as (output[3>>1]+3)&1 by compiler!!!!!!
            output[i] = output[i>>1] + (i&1);
        }
        return output;
    }
}

// Solution 2. DP, consider right most 1:
public class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] output = new int[num+1];
        for (int x=1; x<=num; ++x) {
            output[x] = output[x&(x-1)] + 1;
        }
        return output;
    }
}

