// LeetCode Question:
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

package solutions.LeetCode_75.DP_Multidimensional.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

class Solution {
  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int cash = 0; // Maximum profit if we do not own a stock
    int hold = -prices[0]; // Maximum profit if we own a stock

    for (int i = 1; i < n; i++) {
      cash = Math.max(cash, hold + prices[i] - fee); // Sell stock if profitable
      hold = Math.max(hold, cash - prices[i]); // Buy stock if profitable
    }

    return cash; // Maximum profit at the end without owning a stock
  }
}
