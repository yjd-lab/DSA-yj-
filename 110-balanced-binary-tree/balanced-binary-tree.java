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
    public boolean isBalanced(TreeNode root) {
        return ch(root) != -1;
    }
    public int ch(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = ch(root.left);
        if(left==-1){
            return -1;
        }
        int right = ch(root.right);
        if(right==-1){
            return -1;
        }
         if (Math.abs(left - right) > 1) {
            return -1; 
        }
        return Math.max(left, right) + 1;
    }
}