import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int res = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlace(position, m, mid)) {
                res = mid;
                left = mid + 1; // Try to look for a larger valid minimum distance
            } else {
                right = mid - 1; // Distance is too big, try smaller
            }
        }
        return res;
    }
    
    public boolean canPlace(int[] position, int m, int mid) {
        int balls = 1; // First ball is always placed at position[0]
        int last = position[0];
        
        // FIXED: Start loop at index 1 since the first ball is already placed
        for (int j = 1; j < position.length; j++) {
            if (position[j] - last >= mid) {
                balls++;
                last = position[j];
            }
        }
        // FIXED: Returns true if we placed AT LEAST 'm' balls successfully
        return balls >= m; 
    }
}
