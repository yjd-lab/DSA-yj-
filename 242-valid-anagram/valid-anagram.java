class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        HashMap<Character,Integer> n = new HashMap<>();
        for(char ch : s.toCharArray()){
            n.put(ch,n.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            if(!n.containsKey(ch)||n.get(ch)==0){
                return false;
            }
            n.put(ch,n.get(ch)-1);
        }return true;
    }
}