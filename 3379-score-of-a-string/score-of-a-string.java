class Solution {
    public int scoreOfString(String s) {
        int result=0;
        int n=s.length();
        for (int i = 0 ; i < n-1 ; i++){
            result += Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return result;
    }   
}