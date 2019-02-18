/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        traverse(queue, true, res);
        return res;
    }
    
    private void traverse(Deque<TreeNode> queue, boolean fromLeft, List<List<Integer>> res) {
        if (queue.isEmpty()) {
            return;
        }
        int size = queue.size();
        List<Integer> temp = new ArrayList<>();
        while (size > 0) {            
            if (fromLeft) {
                TreeNode cur = queue.pollFirst();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
            } else {
                TreeNode cur = queue.pollLast();
                temp.add(cur.val);
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
            }
            size--;
        }
        res.add(new ArrayList(temp));
        traverse(queue, !fromLeft, res);
    }
}