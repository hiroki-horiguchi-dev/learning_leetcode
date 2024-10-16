/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }

            slow = slow.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null) return null;

        /// 循環リストだとわかったので、それぞれの操作を施す
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}