class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        int j = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        int req= t.length();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i< t.length() ; i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        for(int i = 0 ; i< s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) > 0) { // i forget this lone always
                    req--;
                }
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
            }
            while(req==0){
                if(i-j+1<min){
                    min = i-j+1;
                    start =j ;
                }
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),map.get(s.charAt(j))+1);
                    if(map.get(s.charAt(j))>0){
                        req++;
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