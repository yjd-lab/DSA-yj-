import java.util.ArrayList;
import java.util.List;

class Solution {
    // Corrected helper method parameters and return type (void)
    void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        result.add(root.val);       // Visit Root (First in Preorder)
        preorder(root.left, result);  // Traverse Left Subtree
        preorder(root.right, result); // Traverse Right Subtree
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
}
