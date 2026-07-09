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
    public int depth = 0; 
    public int maxDepth(TreeNode root) {
        c(root,1);
        return depth;
    }
    public void c(TreeNode root , int count){
        if(root== null){
            return ;
        }
        if(root.left==null && root.right==null){
             depth = Math.max(depth,count);
        }
        c(root.left,count+1);
        c(root.right,count+1);
    }
}