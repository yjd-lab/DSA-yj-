class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Your null check split up so it returns the correct boolean
        if (p == null && q == null) {
            return true; // Both ended at the same time -> Match!
        }
        if (p == null || q == null) {
            return false; // One ended early -> Mismatch!
        }
        
        // 2. Your value check (unchanged)
        if (p.val != q.val) {
            return false;
        }
        
        // 3. Your recursive calls, but capturing the variables instead of ignoring them
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        
        // 4. Only return true if BOTH subtrees also matched perfectly
        return left && right;
    }
}
