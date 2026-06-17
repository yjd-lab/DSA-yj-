class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int w : weights){

            left = Math.max(left, w); // why max?
            // answer: smallest possible valid capacity = largest package
                        //largest possible valid capacity = sum of all packages
            right += w;
        }

        int res = right;
        while(left<=right){
            int mid = left +(right - left)/2;
            int d = 1;
            int currentweight = 0;
            for(int w: weights){
                if(currentweight+w>mid){
                    d++;
                    currentweight = 0;
                }
                currentweight += w;
            }
            if(d>days){
                left = mid+1;
            }else{
                res = mid;
                right = mid-1;
            }
        }
        return res;
    }
}