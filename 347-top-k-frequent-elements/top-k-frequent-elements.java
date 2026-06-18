import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Keep a Min-Heap of size k, sorted by frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll(); // Removes the element with the lowest frequency
            }
        }
        
        // Step 3: Extract elements from the heap into the output array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        
        return result;
    }
}
