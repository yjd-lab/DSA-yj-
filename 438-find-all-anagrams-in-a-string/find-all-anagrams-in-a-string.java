class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int j = 0;
        List<Integer> l = new ArrayList<>();
        HashMap<Character ,Integer> s1 = new HashMap<>();
        HashMap<Character ,Integer> p1 = new HashMap<>();
        if(s.length()<p.length()){
            return l;
        }
        for (int i = 0  ; i< p.length() ; i++){
            s1.put(s.charAt(i),s1.getOrDefault(s.charAt(i),0)+1);
            p1.put(p.charAt(i),p1.getOrDefault(p.charAt(i),0)+1);
        }
        if(s1.equals(p1)){
            l.add(0);
        }
        for(int i = p.length(); i< s.length() ;i++){
            s1.put(s.charAt(i),s1.getOrDefault(s.charAt(i),0)+1);
            s1.put(s.charAt(j),s1.getOrDefault(s.charAt(j),0)-1);
            if(s1.get(s.charAt(j))==0){
                s1.remove(s.charAt(j));
            }
            j++;
            if(s1.equals(p1)){
                l.add(j);
            }
        }
        return  l ;
    }
}