class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelset = new HashSet<>();
        for (int i = 0; i< jewels.length();i++){
            jewelset.add(jewels.charAt(i));
        }
        int score =0;
        for (int i = 0; i< stones.length();i++){
            if(jewelset.contains(stones.charAt(i))){
                score++;
            }
        }return score;
    }
}