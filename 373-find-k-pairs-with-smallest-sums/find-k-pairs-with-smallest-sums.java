
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Result list to store the pairs
        List<List<Integer>> ans = new ArrayList<>();

        // Handle edge cases: if either array is empty or k is 0, return empty list
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }

        // Min-heap tracking: [sum, index_in_nums1, index_in_nums2]
        // Sorted in ascending order by the sum (element at index 0)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Seed the heap with initial candidates.
        // We pair the first element of nums2 with the first k (or all) elements of nums1.
        // We use Math.min to prevent unnecessary insertions past index k-1.
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract the k smallest pairs dynamically
        while (k > 0 && !pq.isEmpty()) {
            // Get the pair with the current global minimum sum
            int[] cur = pq.poll();

            int i = cur[1]; // Index from nums1
            int j = cur[2]; // Index from nums2

            // Add the corresponding values to the result
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            // Move to the next element in nums2 for the current nums1[i] row.
            // This ensures we always explore the next smallest candidate.
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{
                    nums1[i] + nums2[j + 1], i, j + 1
                });
            }
            
            // Decrement k since we have successfully found one of the smallest pairs
            k--;
        }

        return ans;
    }
}
