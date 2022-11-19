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
    public ListNode reversed(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;  
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        int temp;
       
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; 
        }
        slow = reversed(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}