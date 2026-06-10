class Solution {

    public int[] searchRange(int[] nums, int target) {

        int left = binsearch(nums, target, true);

        int right = binsearch(nums, target, false);

        return new int[]{left, right};
    }

    public int binsearch(int[] nums, int target, boolean leftbias){

        int left = 0;

        int right = nums.length - 1;

        int i = -1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(target > nums[mid]){

                left = mid + 1;
            }

            else if(target < nums[mid]){

                right = mid - 1;
            }

            else{

                i = mid;

                // search left side
                if(leftbias){

                    right = mid - 1;
                }

                // search right side
                else{

                    left = mid + 1;
                }
            }
        }

        return i;
    }
}