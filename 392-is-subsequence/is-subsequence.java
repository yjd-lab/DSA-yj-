class Solution {
    public boolean isSubsequence(String s, String t) {
        // Base case: An empty string is always a subsequence of any string
        if (s.isEmpty()) {
            return true;
        }
        // If s is longer than t, it cannot be a subsequence
        if (s.length() > t.length()) {
            return false;
        }
        int left =0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(left)==t.charAt(i)){
                left++;
            }
             // FIX: Stop immediately once all characters in 's' are found
            if (left == s.length()) {
                return true;
            }
        }
        return false;
    }
}