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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummyNode = new ListNode(0);
        ListNode ans = dummyNode;
        for(ListNode ls : lists){
            if(ls != null){
                pq.offer(ls);
            }
        }
        while(!pq.isEmpty()){
            ListNode head = pq.poll();
            if(head.next != null){
                pq.offer(head.next);
            }
            dummyNode.next = head;
            dummyNode = dummyNode.next;
        }
        return ans.next;
    }
}
