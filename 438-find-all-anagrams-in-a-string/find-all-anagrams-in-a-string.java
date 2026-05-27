class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) {
            return res;
        }
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        for (int i = 0 ; i< p.length(); i++){
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i), 0) + 1);
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(smap.equals(pmap)){
             res.add(0);
        }
        for(int i = p.length(); i< s.length() ; i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i), 0) + 1);
            smap.put(s.charAt(i-p.length()),smap.getOrDefault(s.charAt(i-p.length()), 0) - 1);
            if(smap.get(s.charAt(i-p.length()))== 0 ){
                smap.remove(s.charAt(i-p.length()));
            }
            if(smap.equals(pmap)){
                 res.add(i-p.length()+1);
            }
        }
        return res;
    }
}