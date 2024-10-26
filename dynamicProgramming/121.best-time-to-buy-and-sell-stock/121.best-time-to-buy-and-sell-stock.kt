import kotlin.comparisons.maxOf
/*
 * @lc app=leetcode id=121 lang=kotlin
 *
 * [121] Best Time to Buy and Sell Stock
 */
import kotlin.comparisons.minOf

// @lc code=start
class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0

        var left = 0 // 買いの価格のポインタ
        var maxProfit = 0

        for (right in 1 until prices.size) {
            // 買いのポイントより安い価格が見つかれば左ポインタを更新
            if (prices[right] < prices[left]) {
                left = right
            } else {
                // 現在の利益を計算し、最大利益を更新
                maxProfit = maxOf(maxProfit, prices[right] - prices[left])
            }
        }

        return maxProfit
    }
}
// @lc code=end

