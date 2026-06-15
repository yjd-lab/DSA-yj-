class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int j = 0 ;
        double ans = 0;
        double max =0;
        for(int i =0; i<k;i++){
            ans += nums[i];
        }
        max = ans/k;
        for(int i =k;i<nums.length;i++){
            ans-=nums[j];
            ans+=nums[i];
            max = Math.max(max,ans/k);
            j++;
        }
        return max;
    }
}