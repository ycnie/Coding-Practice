/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode116 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connect(root.left, root.right);
    }
    
    private void connect(TreeLinkNode one, TreeLinkNode two) {
        if (one == null || two == null) {
            return;
        }
        connect(one.left, one.right);
        connect(two.left, two.right);
        connect(one.right, two.left);
        one.next = two;
    }
}