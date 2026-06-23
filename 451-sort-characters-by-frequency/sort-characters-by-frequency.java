class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char word : s.toCharArray()) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(b) - map.get(a)
        );
        StringBuilder res = new StringBuilder();
        for(char ch : map.keySet()){
            pq.offer(ch);
        }
        while(!pq.isEmpty()){
            char c = pq.poll();
            int repeat = map.get(c);
            for(int i  = 0; i<repeat;i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}