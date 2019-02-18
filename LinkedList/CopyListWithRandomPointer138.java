/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newHead = dummy; 
        while (cur != null) {
            RandomListNode node = map.getOrDefault(cur, new RandomListNode(cur.label));
            newHead.next = node;
            if (cur.random != null) {
                RandomListNode nodeRandom = map.getOrDefault(cur.random, 
                                                             new RandomListNode(cur.random.label));
                node.random = nodeRandom;
            }
            newHead = newHead.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}