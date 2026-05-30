class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int len = 0;
        int size = 0;
        HashMap<Character, Integer> map  = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            size +=1;
            while(map.get(s.charAt(i))>1){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
                size-=1;
                j++;
            }
            len = Math.max(len,size);
        }return len ; 
    }
}