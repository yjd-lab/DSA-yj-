class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char word : s.toCharArray()) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(b) - map.get(a)
        );
        for(char ch : map.keySet()){
            pq.offer(ch);
        }
        StringBuilder res = new StringBuilder();
        char prev = '#';
        while(!pq.isEmpty()){
            char c = pq.poll();
            res.append(c);
            map.put(c,map.get(c)-1);
            if (prev != '#' &&
                map.get(prev) > 0) {
                pq.offer(prev);
            }   
            prev = c;
        }
        return res.length() == s.length()
                ? res.toString()
                : "";
    }
}