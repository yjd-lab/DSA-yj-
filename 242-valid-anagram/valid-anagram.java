class Solution {
    public boolean isAnagram(String s, String t) {
         if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch-'a']++;
        }
        for (char ch : t.toCharArray()){
            count[ch-'a']--;
            if( count[ch-'a']<0){
                return false;
            }
        } return true;
    }
}
/* 
class Solution {
    public boolean isAnagram(String s, String t) {

        // Optional optimization
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters from s
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Remove characters using t
        for(char ch : t.toCharArray()) {

            if(!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }
}

 */