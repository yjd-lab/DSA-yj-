class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;

        int right = 0;

        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        int res = right;

        while(left <= right){

            int mid = left + (right - left) / 2;

            long hours = 0; // avoid overflow for large hours

            for(int pile : piles){
                hours += (long)(pile + mid - 1) / mid; // this computes ceil(c/mid)
            }

            if(hours <= h){

                res = mid; // no need for Math.min(res,mid)

                right = mid - 1;
            }

            else{

                left = mid + 1;
            }
        }

        return res;
    }
}