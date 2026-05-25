class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> table = new HashMap<>();
        for(char ch : s.toCharArray()){
            table.put(ch,table.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            table.put(ch,table.getOrDefault(ch,0)-1);
            if(table.get(ch)<0){
                return ch;
            }
        }  return ' ';
    }
}