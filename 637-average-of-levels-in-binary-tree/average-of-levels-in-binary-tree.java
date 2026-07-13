import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Fix 1: Instantiate Queue using a concrete class
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            double levelSum = 0; // Use double to prevent overflow and force double division

            for (int i = 0; i < levelSize; i++) {
                // Fix 2: Remove elements from the queue to avoid infinite loop
                TreeNode currentNode = q.poll(); 
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }

            // Fix 3: Direct double calculation prevents integer truncation errors
            result.add(levelSum / levelSize); 
        }

        return result;
    }
}
