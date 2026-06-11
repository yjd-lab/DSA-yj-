class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int n : nums) {
            
            right = Math.max(right, n);
        }
        int res = 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            long t = 0;
            for (int i : nums){
                t += (long)(i+mid-1)/mid;
            }
            if(t<=threshold){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }
}