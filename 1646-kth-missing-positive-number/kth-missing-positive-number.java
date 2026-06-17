class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1; // Fixed: Use arr.length - 1 to match the while condition bounds
        
        while (left <= right) { // Fixed: Loop on right instead of undefined mid
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);
            
            if (missing < k) { // Fixed: Use the 'missing' variable instead of 'd'
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
