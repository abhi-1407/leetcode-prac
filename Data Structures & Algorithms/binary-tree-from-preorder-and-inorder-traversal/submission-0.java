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

class Solution {
    int preIdx = 0;
    private TreeNode buildTreeHelper(int[] preorder, int startIdx, int endIdx, Map<Integer,Integer> inorderMap){
        if(startIdx > endIdx){
            return null;
        }

        int rootVal = preorder[preIdx++];
        int rootIdx = inorderMap.get(rootVal);

        TreeNode rootNode = new TreeNode(rootVal);
        TreeNode lNode = buildTreeHelper(preorder, startIdx, rootIdx - 1,inorderMap);
        TreeNode rNode = buildTreeHelper(preorder, rootIdx + 1, endIdx,inorderMap);

        rootNode.left = lNode;
        rootNode.right = rNode;
        return rootNode; 
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            inorderMap.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,0,n - 1,inorderMap);
    }
}
