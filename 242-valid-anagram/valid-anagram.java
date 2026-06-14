import java.util.HashMap;

class Solution { 
    public boolean isAnagram(String s, String t) { 
        // If lengths don't match, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>(); 
        
        // Count frequencies of characters in string s
        for (int i = 0; i < s.length(); i++) { 
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); 
        } 
        
        // Decrement frequencies using string t
        for (int i = 0; i < t.length(); i++) { 
            char c = t.charAt(i);
            
            // If character doesn't exist in the map, it's not an anagram
            if (!map.containsKey(c)) {
                return false;
            }
            
            // Corrected put syntax: key followed by the decremented value
            map.put(c, map.get(c) - 1); 
            
            // Corrected remove method
            if (map.get(c) == 0) { 
                map.remove(c); 
            } 
        } 
        
        // If the map is empty, all character counts matched perfectly
        return map.isEmpty(); 
    } 
}
