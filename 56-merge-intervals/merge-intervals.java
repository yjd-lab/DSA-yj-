class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }

        // 1. Corrected Bubble Sort: Sorts entire rows by start time
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) { // Fixed boundary (n - i - 1)
                if (intervals[j][0] > intervals[j + 1][0]) {
                    // Swap the entire 1D array reference safely
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        // 2. Setup the results array
        int[][] res = new int[n][2]; // Intervals always have 2 columns, not 'n'
        int index = 0;
        
        // Seed the first interval
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        // 3. Merge Pass
        for (int i = 1; i < n; i++) {
            // Check for overlap: current start time <= previous merged end time
            if (intervals[i][0] <= res[index][1]) {
                // Overlap: Expand the end time to the maximum value
                if (intervals[i][1] > res[index][1]) {
                    res[index][1] = intervals[i][1];
                }
            } else {
                index++;
                res[index][0] = intervals[i][0];
                res[index][1] = intervals[i][1];
            }
        }
        int[][] finalResult = new int[index + 1][2];
        for (int i = 0; i <= index; i++) {
            finalResult[i] = res[i];
        }

        return finalResult;
    }
}
