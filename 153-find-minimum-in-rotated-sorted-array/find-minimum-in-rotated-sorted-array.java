class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            if (nums[left]<nums[right]){ //if sorted array
                min=Math.min(min,nums[left]);
                break;
            }
            int mid = left +(right - left )/2;
            min=Math.min(min,nums[mid]);
            // if mid is of left part move right
            if(nums[mid]>=nums[left]){
                left = mid+1;
            }
            //if mid is of right part move left
            else{
                right=mid-1;
            }
        }
        return min;
    }
}