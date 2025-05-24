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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode head = res;
        int rem = 0, val = 0;

        while (l1 != null && l2 != null){
            val =  l1.val + l2.val + rem;
            rem = val/10;
            val = val%10;
            ListNode next = new ListNode(val);
            res.next = next;
            res = next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            val = l1.val + rem;
            rem = val/10;
            val = val%10;
            ListNode next = new ListNode(val);
            res.next = next;
            res = next;
            l1 = l1.next;
        }

        while (l2 != null){
            val = l2.val + rem;
            rem = val/10;
            val = val%10;
            ListNode next = new ListNode(val);
            res.next = next;
            res = next;
            l2 = l2.next;
        }

        if (rem != 0){
        ListNode next = new ListNode(rem);
        res.next = next;
        }
        return head.next;

       
        
    }
}