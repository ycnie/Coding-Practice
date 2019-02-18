/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbersII445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        ListNode l1Rev = reverse(l1);
        ListNode l2Rev = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode prev = null;
        dummy.next = l1Rev;
        int carry = 0;
        while (l1Rev != null && l2Rev != null) {
            int sum = l1Rev.val + l2Rev.val + carry;
            carry = sum / 10;
            l1Rev.val = sum % 10;
            prev = l1Rev;
            l1Rev = l1Rev.next;
            l2Rev = l2Rev.next;
        }
        if (l1Rev== null && l2Rev != null) {
            prev.next = l2Rev;
        }
        ListNode cur = prev.next;
        while (cur != null && carry != 0) {
            int curSum = carry + cur.val;
            carry = curSum / 10;
            cur.val = curSum % 10;
            prev = cur;
            cur = cur.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}