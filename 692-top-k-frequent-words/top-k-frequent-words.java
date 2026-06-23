import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. Populate the frequency map
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // 2. Initialize Min-Heap with custom comparator
        // Lower frequencies stay at the top. 
        // If frequencies are equal, lexicographically greater words stay at the top.
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b)
        );
        
        // 3. Keep only the top k elements in the heap
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // 4. Build the final sorted result list
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        
        // Since it's a min-heap, elements are pulled out smallest to largest. 
        // Reverse it to get the highest frequency first.
        Collections.reverse(res);
        return res;
    }
}
