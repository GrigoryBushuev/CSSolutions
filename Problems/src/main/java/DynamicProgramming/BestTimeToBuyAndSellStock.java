package DynamicProgramming;

/*121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
*/

/*
The idea is to maximize the profit that is a difference between buy price and sell price. profit = sellPrice - buyPrice.
To find the max profit we can do either find the min buy price or to find the max sell price.
To find the min buy price is easier in our case. We just iterate over the array and compare previously found min buy price
with the currently scanned price. Then we calculate profit which is the diff between the current price and minPrice in the subarray
that we scanned so far.

Time complexity: O(n) as we iterate each element only once
Space complexity O(1) as we need memory for two variables only
*/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        var minBuyPriceSoFar = prices[0];
        var profit = 0;
        for (var i = 1; i < prices.length; i++) {
            minBuyPriceSoFar = Math.min(prices[i], minBuyPriceSoFar);
            profit = Math.max(profit, prices[i] - minBuyPriceSoFar);
        }
        return profit;
    }
}