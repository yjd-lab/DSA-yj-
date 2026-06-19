import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. Count frequencies
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {  
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // 2. Min-Heap configuration
        // Sorts primarily by lower frequency. 
        // If frequencies match, sorts alphabetically (lexicographically) in reverse.
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b)
        );
        
        // 3. Iterate over the Map keys, NOT the array indices
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Ejects the lowest frequency / worst alphabetical word
            }
        }
        
        // 4. Build the final result list
        LinkedList<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            // Since it's a min-heap, adding to the front reverses it into descending order
            result.addFirst(pq.poll());
        }
        
        return result;
    }
}
