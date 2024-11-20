/*
 * @lc app=leetcode id=153 lang=kotlin
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    fun findMin(nums: IntArray): Int {
        /// 方針
        /// 最小値を見つける
        /// 二分探索で左右中央から絞っていく
        /// 最終的には left の値を返すことにする
        /// input のnums はサイズが 5000 なので、計算時にオーバーフローは考慮しない

        var left = 0
        var right = nums.size - 1

        while (left < right) {

            val mid = (left + right) / 2

            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return nums[left]
    }
}
// @lc code=end

