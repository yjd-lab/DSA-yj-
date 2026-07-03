import java.util.ArrayList;
import java.util.List;

class Solution {
    // Helper method for Postorder (Left -> Right -> Root)
    void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        postorder(root.left, result);  // Traverse Left Subtree
        postorder(root.right, result); // Traverse Right Subtree
        result.add(root.val);         // Visit Root (Last in Postorder)
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
}
