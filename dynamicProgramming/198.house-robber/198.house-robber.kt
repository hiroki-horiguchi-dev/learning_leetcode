/*
 * @lc app=leetcode id=198 lang=kotlin
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]

        var prev1 = maxOf(nums[0], nums[1])
        var prev2 = nums[0]

        for (i in 2..nums.size - 1) {
            val temp = prev1
            prev1 = maxOf(prev1, prev2 + nums[i])
            prev2 = temp
        }

        return prev1
    }
}
// @lc code=end

