/*
 * @lc app=leetcode id=35 lang=kotlin
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1

        while (low <= high) {
            val mid = low + (high - low) / 2

            when {
                nums[mid] == target -> return mid // ターゲットが見つかった場合
                nums[mid] < target -> low = mid + 1 // ターゲットが右側にある場合
                else -> high = mid - 1 // ターゲットが左側にある場合
            }
        }
        return low // 挿入位置を返す
    }
}
// @lc code=end

