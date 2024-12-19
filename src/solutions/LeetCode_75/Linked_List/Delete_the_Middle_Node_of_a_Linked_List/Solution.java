// LeetCode Question: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

package solutions.LeetCode_75.Linked_List.Delete_the_Middle_Node_of_a_Linked_List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // If there's only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast pointer twice as fast as the slow pointer
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Skip the middle node
        prev.next = slow.next;

        return head;
    }
}

