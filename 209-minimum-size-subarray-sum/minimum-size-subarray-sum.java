class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int t = 0;
        int res = nums.length + 1;
        for(int j=0;j<nums.length;j++){
            t+=nums[j];
            while(t>=target){
                res= Math.min(res,j-i+1);
                t-= nums[i];
                i++;
            }

        }if(res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}