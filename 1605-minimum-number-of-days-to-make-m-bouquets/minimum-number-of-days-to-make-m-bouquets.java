class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Prevent integer overflow: if required flowers exceed total available flowers, it's impossible
        if ((long)m * k > bloomDay.length) {
            return -1;
        }

        // Initialize search range boundaries
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // Find the absolute minimum and maximum days in the array to set our binary search bounds
        for (int day : bloomDay) {
            left = Math.min(left, day);   // The earliest any flower can bloom
            right = Math.max(right, day); // The latest day when all flowers will have bloomed
        }

        int res = -1; // Variable to store our minimum valid days answer
        
        // Start Binary Search on the answer space (days)
        while (left <= right) {
            // Safely calculate the middle day to test without causing integer overflow
            int mid = left + (right - left) / 2;
            
            int flowers = 0;  // Tracks current consecutive bloomed flowers
            int bouquets = 0; // Tracks total bouquets formed on 'mid' day
            
            // Loop through each flower to see if it has bloomed by day 'mid'
            for (int days : bloomDay) {
                if (days <= mid) {
                    flowers++; // This flower has bloomed! Increment consecutive count
                    
                    // If we collected enough consecutive flowers to form a bouquet
                    if (flowers == k) {
                        bouquets++;  // Successfully made one bouquet
                        flowers = 0; // FIXED: Reset consecutive count to start the next bouquet fresh
                    }
                } else {
                    flowers = 0; // This flower hasn't bloomed yet; breaks the consecutive streak, so reset
                }
            }
            
            // If the total bouquets formed on 'mid' day is enough to satisfy 'm'
            if (bouquets >= m) {
                res = mid;       // Record 'mid' as a potential answer
                right = mid - 1; // Try to look left for a smaller, more optimal number of days
            } else {
                left = mid + 1;  // Not enough bouquets; we need more days for more flowers to bloom
            }
        }
        return res; // Return the minimum valid days found
    }
}
