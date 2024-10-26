/*
 * @lc app=leetcode id=122 lang=kotlin
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0

        for (i in 1..prices.size - 1) {
            if (prices[i - 1] < prices[i]) {
                profit += (prices[i] - prices[i-1])
            }
        }
        return profit
    }
}
// @lc code=end

