/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinarySearchTreeIterator173 {

    Deque<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        if (root != null) {   
            pushAllLeft(root);
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode curSmallest = stack.pollFirst();
        if (curSmallest.right != null) {
            pushAllLeft(curSmallest.right);
        }
        return curSmallest.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAllLeft(TreeNode node) {
        stack.offerFirst(node);
        while (node.left != null) {
            stack.offerFirst(node.left);
            node = node.left;
        }
    } 
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */