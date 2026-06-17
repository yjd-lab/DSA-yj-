class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // Fixed: Set upper bound to last valid index
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Optional optimization: Return immediately if found
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
