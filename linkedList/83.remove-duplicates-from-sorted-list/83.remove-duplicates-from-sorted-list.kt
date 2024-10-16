/*
 * @lc app=leetcode id=83 lang=kotlin
 *
 * [83] Remove Duplicates from Sorted List
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
        var current = head

        while (current != null && current?.next != null) {
            if (current?.`val` == current?.next?.`val`) {
                current?.next = current?.next?.next
            } else {
                current = current?.next
            }
        }

        return head
    }
}
// @lc code=end

