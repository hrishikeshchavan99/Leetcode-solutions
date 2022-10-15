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
    public ListNode reverseList(ListNode head) {
        ListNode prev, cur, nxt;
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null){
            cur = head.next;
            cur.next = head;
            head.next = null;
            return cur;
        }
        prev = head;
        cur = prev.next;
        nxt = cur.next;
        prev.next = null;
        
        while(nxt != null){
            cur.next = prev;
            prev = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        cur.next = prev;
        return cur;
    }
}