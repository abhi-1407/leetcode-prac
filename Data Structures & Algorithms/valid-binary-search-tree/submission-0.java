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
    private boolean isValid(TreeNode root, long minVal, long maxVal){
        if(root == null){
            return true;
        }
        if(root.val <= minVal || root.val >= maxVal){
            return false;
        }
        boolean leftTreeValid = isValid(root.left,minVal,root.val);
        boolean rightTreeValid = isValid(root.right,root.val,maxVal);
        return leftTreeValid && rightTreeValid;
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root,-1001,1001);
    }
}
