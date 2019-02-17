/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findTilt(TreeNode root) {
        int[] sumTilt = new int[1];
        findTilt(root, sumTilt);
        return sumTilt[0];
    }
    
    private int findTilt(TreeNode node, int[] sumTilt) {
        if (node == null) {
            return 0;
        }
        int leftSum = findTilt(node.left, sumTilt);
        int rightSum = findTilt(node.right, sumTilt);
        sumTilt[0] += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}

// Time: O(n)
// Space: O(h) call stack