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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, ehead = head.next, ecur = ehead;

        while (cur.next != null && ecur.next != null){
            cur.next = ecur.next;
            cur = cur.next;
            ecur.next = cur.next;
            ecur = ecur.next;
        }

        cur.next = ehead;

        return head;

    }
}