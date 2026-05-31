class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        int j = 0;
        int required = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int start =0;
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i< t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        for(int i = 0; i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) > 0) {
                    required--;
                }
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
            }
            while(required==0){
                if(i-j+1 < min){
                    min = i-j+1;
                    start = j ;
                }
                if(map.containsKey(s.charAt(j))){
                    
                    map.put(s.charAt(j),map.get(s.charAt(j))+1);
                    if(map.get(s.charAt(j))>0){
                        required++;
                    }
                }
                j++;
            }
        }
        if(min == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + min);
    }
}