// https://leetcode.com/articles/coin-change/

//很容易写错。memory[]的初始值很关键。memory[0]为0.
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        int[] memory = new int[amount+1];
        Arrays.fill(memory, Integer.MAX_VALUE);
        memory[0] = 0;
        for (int i=1; i<=amount; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; ++j) {
                if (i-coins[j] >= 0) {
                    min = Math.min(min, memory[i-coins[j]]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                memory[i] = min+1;
            }
        }
        return memory[amount] != Integer.MAX_VALUE ? memory[amount] : -1;
    }
}
