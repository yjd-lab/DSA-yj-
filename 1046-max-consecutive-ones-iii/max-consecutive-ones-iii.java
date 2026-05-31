class Solution {
    public int longestOnes(int[] nums, int k) {
        int j = 0 ;
        int zeroes = 0;
        int max = 0;
        for(int i = 0 ; i< nums.length ; i++){
            if(nums[i] == 0){
                zeroes += 1;
            }
            while(zeroes> k ){
                if(nums[j] == 0){
                zeroes -= 1;
                }
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}