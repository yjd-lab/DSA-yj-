class Solution {
    public boolean isBalanced(TreeNode root) {
        // If the helper function returns -1, it means the tree is unbalanced
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        // Base case: an empty tree has a height of 0
        if (root == null) {
            return 0;
        }

        // 1. Check the height of the left subtree
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1; // Left side is already unbalanced, bubble the error up
        }

        // 2. Check the height of the right subtree
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1; // Right side is already unbalanced, bubble the error up
        }

        // 3. Check if the current node breaks the balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is unbalanced!
        }

        // 4. If balanced, return the actual height of this subtree to the parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
