/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private void serializeHelper(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }

    int index = 0;
    private TreeNode deserializeHelper(String[] nodes){
        String curr = nodes[index++];
        if(curr.equals("N")){
            return null;
        }
        TreeNode left = deserializeHelper(nodes);
        TreeNode right = deserializeHelper(nodes);
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = left;
        root.right = right;
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeHelper(nodes);
    }
}
