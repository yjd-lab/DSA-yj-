class Solution {
    // Global variable to keep track of the maximum diameter found so far
    public int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return res;
    }

    public int diameter(TreeNode root) {
        // 1. Base Case: If the node is null, its height is 0
        if (root == null) {
            return 0;
        }

        // 2. Get the maximum height of left and right subtrees
        int left = diameter(root.left);
        int right = diameter(root.right);

        // 3. Update the global maximum diameter if the path through 
        // the current node is larger than what we've seen so far
        res = Math.max(res, left + right);

        // 4. Return the height of this subtree to the parent node
        // (We take the longer path and add 1 for the current node)
        return Math.max(left, right) + 1;
    }
}
