class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        // 'right' scans through the entire array
        for (int right = 0; right < nums.length; right++) {
            // FIX: Check if the element at 'right' is non-zero
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; 
            }
        }
    }
}
