/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        Queue<ListNode> pq = new PriorityQueue<>(16, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode one, ListNode two) {
                return Integer.compare(one.val, two.val);
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        putAllFirstNode(lists, pq);
        while (!pq.isEmpty()) {
            ListNode curNode = pq.poll();
            head.next = curNode;
            head = head.next;
            curNode = curNode.next;
            if (curNode != null) {
                pq.offer(curNode);
            }
        }
        return dummy.next;
    }
    
    private void putAllFirstNode(ListNode[] lists, Queue<ListNode> pq) {     
        for (int i = 0; i < lists.length; i++) {
            ListNode curNode = lists[i];
            if (curNode != null) {
                pq.offer(curNode);
            }
        }
    }
    
}


// Time: (nlogk)
// Space: O(k)

