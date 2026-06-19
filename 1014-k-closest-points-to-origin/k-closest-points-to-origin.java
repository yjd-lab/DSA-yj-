import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap: orders elements from largest distance to smallest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] point : points) {
            pq.offer(point);
            // If we exceed k elements, remove the one with the largest distance
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // Convert the PriorityQueue directly into the required 2D array
        return pq.toArray(new int[k][]);
    }
}
