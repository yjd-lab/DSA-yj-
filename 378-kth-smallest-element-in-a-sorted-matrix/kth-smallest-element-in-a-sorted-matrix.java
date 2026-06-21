class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {

                pq.offer(num);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
/*
CORRECT SOLUTION:
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        // [value, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Push first element of each row
        for (int r = 0; r < n; r++) {
            pq.offer(new int[]{
                matrix[r][0],
                r,
                0
            });
        }

        // Remove the smallest k-1 elements
        for (int i = 0; i < k - 1; i++) {

            int[] curr = pq.poll();

            int row = curr[1];
            int col = curr[2];

            // Push next element in the same row
            if (col + 1 < matrix[row].length) {
                pq.offer(new int[]{
                    matrix[row][col + 1],
                    row,
                    col + 1
                });
            }
        }

        return pq.peek()[0];
    }
}
 */