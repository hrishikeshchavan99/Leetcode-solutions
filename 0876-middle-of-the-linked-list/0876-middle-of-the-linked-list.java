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
    public ListNode middleNode(ListNode head) {
        ListNode cur = head.next;
        while(cur != null){
            head = head.next;
            if (cur.next != null ) cur = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}