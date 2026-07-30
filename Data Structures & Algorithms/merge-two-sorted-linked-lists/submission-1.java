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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummyNode.next = new ListNode(l1.val);
                l1 =l1.next;
            }else{
                dummyNode.next = new ListNode(l2.val);
                l2 =l2.next;
            }
            dummyNode = dummyNode.next;
        }

        if(l1 != null){
            dummyNode.next = l1;
        }

        if(l2 != null){
            dummyNode.next = l2;
        }

        return head.next;
    }
}