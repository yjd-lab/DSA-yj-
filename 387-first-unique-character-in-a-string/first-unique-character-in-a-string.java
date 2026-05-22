class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        
        }
        int n = s.length();
        for (int i =0;i<n;i++){
            char ch=s.charAt(i);
            if(count[ch-'a']==1){
                return i;
            }
        }return -1;
    }
}

/*class Solution {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequencies
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find first unique character
        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(map.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}*/ 