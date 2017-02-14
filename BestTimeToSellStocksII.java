// https://leetcode.com/articles/best-time-buy-and-sell-stock-ii/.

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0, low, high;
        int i=0;
        // 这个很容易搞错!!当已经到了最后一个的时候要quit.
        while (i+1 < prices.length) {
            low = high = prices[i];
            while (i+1 < prices.length && prices[i+1] >= prices[i]) {
                high = prices[i+1];
                ++i;
            }
            max += high-low;
            while (i+1<prices.length && prices[i+1] < prices[i]) {
                ++i;
            }
        }
        return max;
    }
}

// Solution 2.
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i=0; i+1<prices.length; ++i) {
            if (prices[i+1] > prices[i]) {
                max += prices[i+1]-prices[i];
            }
        }
        return max;
    }
}
