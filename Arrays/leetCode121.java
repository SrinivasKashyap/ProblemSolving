/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class leetCode121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (max < prices[i]) {
                max = prices[i];
            } else {
                profit = Math.max(max - prices[i], profit);
            }
        }
        return profit;
    }
}
