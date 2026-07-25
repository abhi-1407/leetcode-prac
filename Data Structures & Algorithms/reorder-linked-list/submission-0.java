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
    private ListNode getSecondHalf(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        return second;
    }
    private ListNode reverseLL(ListNode head){
        ListNode curr = head, next = head,prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }   
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode secondHalf = getSecondHalf(head);
        ListNode reversedList = reverseLL(secondHalf);
        ListNode first = head, second = reversedList;
        while(first != null && second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}