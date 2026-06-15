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
/*more optimized way :
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Avoids needing a separate 'j' pointer
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum / k;
    }
}

*/