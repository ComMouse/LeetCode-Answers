public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int profit = 0;
        int profitSum = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i - 1] > prices[i]) {
                profitSum += profit;
                profit = 0;
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }
        profitSum += profit;
        
        return profitSum;
    }
}