class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0 ;
        int max =0 ; 
        int current= 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            current += 1;
           while(map.get(s.charAt(i)) > 1){

                map.put(s.charAt(j),
                map.get(s.charAt(j)) - 1);

                current--;

            if(map.get(s.charAt(j)) == 0){
                map.remove(s.charAt(j));
            }

            j++;
        }
            max=Math.max(max,current);

        }
        return max;
    }
}