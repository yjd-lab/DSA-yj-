class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset)); // we are copying the subset
            return;
        }
        subset.add(nums[i]); // add the num and go forward
        dfs(i + 1, nums, subset, res);
        subset.remove(subset.size() - 1); // remove the number and backtrack
        dfs(i + 1, nums, subset, res);
    }
}
