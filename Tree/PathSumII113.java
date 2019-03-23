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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void pathSum(TreeNode node, int leftSum, List<Integer> curList, List<List<Integer>> res){
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && leftSum == node.val) {
            curList.add(node.val);
            res.add(new ArrayList(curList));
            curList.remove(curList.size() - 1);
            return;
        }
        curList.add(node.val);
        pathSum(node.left, leftSum - node.val, curList, res);
        pathSum(node.right, leftSum - node.val, curList, res);
        curList.remove(curList.size() - 1);
    }
}