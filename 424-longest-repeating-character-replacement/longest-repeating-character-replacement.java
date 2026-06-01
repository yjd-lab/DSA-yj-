class Solution {
    public int characterReplacement(String s, int k) {
        int j  = 0 ;
        int maxlen= 0 ;
        int result = 0;
        HashMap<Character,Integer> map =new HashMap<>();
        for (int i = 0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            maxlen=Math.max(maxlen,map.get(s.charAt(i)));
            while(i-j+1 - maxlen > k){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
                j++;
            }
            result = Math.max(result,i-j+1);
        }
        return result;
    }
}