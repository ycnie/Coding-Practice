/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FlattenBinaryTreeToLinkedList114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenTree(root);
    }
    
    private TreeNode flattenTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            return flattenTree(root.right);
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return flattenTree(root.right);
        }
        TreeNode lastSeen = flattenTree(root.left);
        TreeNode curLeft = root.left;
        TreeNode curRight = root.right;
        root.left = null;
        root.right = curLeft;
        lastSeen.right = curRight;
        return flattenTree(curRight);
    }
}