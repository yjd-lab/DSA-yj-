class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int d1 = Math.abs(a - x);
                int d2 = Math.abs(b - x);

                if (d1 == d2) {
                    return b - a;
                }

                return d2 - d1;
            }
        );

        for (int n : arr) {
            pq.offer(n);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        Collections.sort(res);
        return res;
    }
}