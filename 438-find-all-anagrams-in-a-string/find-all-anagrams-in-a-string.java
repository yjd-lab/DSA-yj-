class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()) {
            return list;
        }
        int j = 0;
        HashMap<Character,Integer> m1 = new HashMap<>();
        HashMap<Character,Integer> m2 = new HashMap<>();
        for(int i = 0; i <p.length();i++){
            m1.put(p.charAt(i),m1.getOrDefault(p.charAt(i),0)+1);
            m2.put(s.charAt(i),m2.getOrDefault(s.charAt(i),0)+1);
        }
        if(m1.equals(m2)){
            list.add(0);
        }
        for(int i =p.length();i<s.length();i++){
            m2.put(s.charAt(j),m2.get(s.charAt(j))-1);
            if(m2.get(s.charAt(j))==0){
                m2.remove(s.charAt(j));
            }
            j++;
            m2.put(s.charAt(i),m2.getOrDefault(s.charAt(i),0)+1);
            if(m1.equals(m2)){
                list.add(j);
            }
        }
        return list;
    }
}