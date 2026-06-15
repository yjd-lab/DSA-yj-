class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;
        for(int i =0;i<k;i++){
            if(isVowels(s.charAt(i))){
                count++;
            }
        }
        max = count;
        for(int i = k ; i< s.length();i++){
            if(isVowels(s.charAt(i))){
                count++;
            }
            if(isVowels(s.charAt(i-k))){ // to check if the char we are removing is a vowel or not.
                count--;
            }
            max=Math.max(max,count);
        }
        return max;
    }
    public boolean isVowels(char c){
        return c =='a'||c =='e'||c =='i'||c =='o'||c =='u';
    }
}