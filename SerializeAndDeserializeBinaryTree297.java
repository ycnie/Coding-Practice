/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> serialized = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                serialized.add(null);
                continue;
            }
            serialized.add(cur.val);
            queue.add(cur.left);
            queue.add(cur.right);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < serialized.size(); i++) {
            Integer currentNumber = serialized.get(i);
            if (currentNumber == null) {
                sb.append("null");
            } else {
                sb.append(currentNumber);
            }
            if (i < serialized.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> indexOfNodes = new ArrayList<>();
        deserialize(data, indexOfNodes);
        return constructTree(indexOfNodes);
    }
    
    private void deserialize(String data, List<TreeNode> indexOfNodes) {
        int number = 0;
        int sign = 1;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == ',') {
                number *= sign;
                TreeNode node = new TreeNode (number);
                indexOfNodes.add(node);
                number = 0;
                sign = 1;
            } else {
                indexOfNodes.add(null);
                i += 4;
            }
        }
    }
    
    private TreeNode constructTree(List<TreeNode> indexOfNodes) {
        int countNulls = 0;
        for (int i = 0; i < indexOfNodes.size(); i++) {
            TreeNode cur = indexOfNodes.get(i);
            if (cur == null) {
                countNulls++;
            } else {
                cur.left = indexOfNodes.get(2 * (i - countNulls) + 1);
                cur.right = indexOfNodes.get(2 * (i - countNulls + 1));
            }
        }
        return indexOfNodes.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));