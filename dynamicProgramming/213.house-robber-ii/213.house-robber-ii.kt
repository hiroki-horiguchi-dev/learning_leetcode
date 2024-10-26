

import kotlin.comparisons.maxOf
/*
 * @lc app=leetcode id=213 lang=kotlin
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])

        /// 最初の家を含むパターン、含まないパターン
        val robFirstToSecond = robLinear(nums, 0, nums.size - 2)
        val robSecondToLast  = robLinear(nums, 1, nums.size - 1)

        return maxOf(robFirstToSecond, robSecondToLast)
    }

    private fun robLinear(
        nums: IntArray,
        start: Int,
        end: Int
    ): Int {
        var prev1 = 0
        var prev2 = 0
        
        for (i in start..end) {
            val temp = prev1
            prev1 = maxOf(prev1, prev2 + nums[i])
            prev2 = temp
        }

        return prev1
    }
}
// @lc code=end

