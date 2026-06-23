class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                int dist1 = a[0] * a[0] + a[1] * a[1];
                int dist2 = b[0] * b[0] + b[1] * b[1];
                return dist2-dist1;}
        );
        for (int i[] : points){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }

        }
        return pq.toArray(new int[k][]);
    }
}