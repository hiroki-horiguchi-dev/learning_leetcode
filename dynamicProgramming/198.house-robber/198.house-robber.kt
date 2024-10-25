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

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        
        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i-1], dp[i-2] + nums[i])
        } 

        return dp[nums.size - 1]
    }
}
// @lc code=end

