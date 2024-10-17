/*
 * @lc app=leetcode id=2 lang=kotlin
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummyHead: ListNode = ListNode(0)
        var node_l1 = l1
        var node_l2 = l2

        /// ノード作成用の現在位置を指すポインタ
        var current = dummyHead
        
        /// 繰り上げ
        var carry = 0

        while (node_l1 != null || node_l2 != null || carry != 0) {
            val val1 = node_l1?.`val` ?: 0
            val val2 = node_l2?.`val` ?: 0

            val sum = val1 + val2 + carry
            carry = sum / 10
            val result = sum % 10
            current.next = ListNode(result)

            /// ポインタの移動
            current = current.next

            node_l1 = node_l1?.next
            node_l2 = node_l2?.next
        }

        return dummyHead.next
    }
}
// @lc code=end
