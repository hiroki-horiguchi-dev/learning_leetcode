/*
 * @lc app=leetcode id=198 lang=kotlin
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    fun rob(nums: IntArray): Int {
        return maxOf(even(nums), odd(nums))
    }

    fun even(nums: IntArray): Int {
        var result = 0;
        for (i in nums.indices step 2) {
            result += nums[i]
        }
        return result
    }

    fun odd(nums: IntArray): Int {
        var result = 0;
        for (i in 1 until nums.size step 2) {
            result += nums[i]
        }
        return result
    }
}
// @lc code=end

