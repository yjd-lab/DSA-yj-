import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Fix 1: Use Character as the key type
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Fix 3: Count characters available in the magazine first
        for (char i : magazine.toCharArray()){
            map.put(i, map.getOrDefault(i, 0) + 1);
        } 
        
        // Check if ransomNote can be constructed
        for (int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            
            // If the character is missing or we ran out of it, we can't build it
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            
            // Use up one character
            map.put(ch, map.get(ch) - 1);
        }
        
        // If we successfully matched every character in ransomNote, return true
        return true;
    }
}
