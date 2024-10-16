/*
 * @lc app=leetcode id=82 lang=kotlin
 *
 * [82] Remove Duplicates from Sorted List II
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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null
        
        /// ダミーを先頭に仕込む
        val dummyNode: ListNode? = ListNode(0)
        dummyNode?.next = head

        /// current, prev を定義
        var prev = dummyNode
        var current = head

        while (current != null) {

            /// 重複がある場合
            if (current.next != null && current.`val` == current.next.`val`) {
                /// 重複が2つ以上ある場合を考慮
                while (current?.next != null && current?.`val` == current?.next?.`val`) {
                    current = current?.next
                }
                /// prev.next を重複のないノードに設定
                prev?.next = current?.next
            } else {
                /// 重複がない場合は prev を進める
                prev = prev?.next
            }

            current = current?.next
        }

        return dummyNode?.next
    }
}
// @lc code=end

