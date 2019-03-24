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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        addRightSide(root, 0, res);
        return res;
    }
    
    private void addRightSide(TreeNode root, int curDepth, List<Integer> res) {
        if (root == null) {
            return;
        } 
        if (curDepth == res.size()) {
            res.add(root.val);
        }
        addRightSide(root.right, curDepth + 1, res);
        addRightSide(root.left, curDepth + 1, res);
    }
}