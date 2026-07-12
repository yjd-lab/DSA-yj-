class Solution {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = k; // Initialize our countdown
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 1. Go Left
        traverse(root.left);

        // 2. Process Current Node
        count--; // We found the next smallest element
        if (count == 0) {
            result = root.val; // Found it!
            return; // Stop early
        }

        // 3. Go Right
        traverse(root.right);
    }
}
