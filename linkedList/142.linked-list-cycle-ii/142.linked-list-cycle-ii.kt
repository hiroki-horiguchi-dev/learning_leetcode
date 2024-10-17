/*
 * @lc app=leetcode id=142 lang=kotlin
 *
 * [142] Linked List Cycle II
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
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null

        var slow = head
        var fast = head

        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == fast) {
                break
            }
        }

        if (fast == null || fast?.next == null) return null

        slow = head

        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }

        return slow 
    }
}
// @lc code=end

