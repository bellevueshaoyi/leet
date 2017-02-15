public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i=1; i<prices.length; ++i) {
            min = Math.min(min, prices[i]);
            max = Math.max(prices[i]-min, max);
        }
        return max;
    }
}
