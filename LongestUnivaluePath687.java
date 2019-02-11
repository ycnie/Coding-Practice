/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LongestUnivaluePath687 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxPath = new int[1];
        dfs(root, maxPath);
        return maxPath[0];
    }
    
    private int dfs(TreeNode node, int[] maxPath) {
        if (node == null) {
            return 0;
        }
        int leftPath = dfs(node.left, maxPath);
        int rightPath = dfs(node.right, maxPath);
        leftPath = node.left != null && node.left.val == node.val ? leftPath + 1 : 0;
        rightPath = node.right != null && node.right.val == node.val ? rightPath + 1 : 0;
        maxPath[0] = Math.max(maxPath[0], leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    } 
}