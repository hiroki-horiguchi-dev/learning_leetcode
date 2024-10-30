

import kotlin.comparisons.minOf
/*
 * @lc app=leetcode id=322 lang=kotlin
 *
 * [322] Coin Change
 */

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1}

        dp[0] = 0

        for (i in 1..amount) {
            for(coin in coins) {
                if (i - coin >= 0) {
                    dp[i] = minOf(dp[i], dp[i-coin] + 1)
                }
            }
        }

        return if (dp[amount] > amount) - 1 else dp[amount]
    }
}
// @lc code=end

