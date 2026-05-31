class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int total = 0;
        int result = nums.length +1;
        for(int i =0;i<nums.length; i++){
            total+=nums[i];
            while(total>= target){
                 result = Math.min(result,i-j+1);
                 total-=nums[j];
                 j++;
            }

        }
        if(result == nums.length + 1) {
            return 0;
        }
        return result;
    }
}