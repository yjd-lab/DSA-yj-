class Solution {

    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        for(int n : nums){
            left = Math.max(left, n);
            right += n;
        }

        int res = right;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(cansplit(nums, mid, k)){

                res = mid;
                right = mid - 1;
            }

            else{

                left = mid + 1;
            }
        }

        return res;
    }

    public boolean cansplit(int[] nums, int limit, int k){

        int subarrays = 1;
        int currentSum = 0;

        for(int n : nums){

            currentSum += n;

            if(currentSum > limit){

                subarrays++;
                currentSum = n;
            }
        }

        return subarrays <= k;
    }
}