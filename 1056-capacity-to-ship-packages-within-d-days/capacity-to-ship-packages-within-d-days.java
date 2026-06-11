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

        while(left <= right){

            int mid = left + (right - left) / 2;

            int d = 1; // before loading anything we are already on day 1
            int currentWeight = 0;

            for(int weight : weights){ // this whole block is importnant

                if(currentWeight + weight > mid){

                    d++;

                    currentWeight = 0;
                }

                currentWeight += weight; // very importnant
            }

            if(d > days){

                left = mid + 1;
            }

            else{

                res = mid;

                right = mid - 1;
            }
        }

        return res;
    }
}