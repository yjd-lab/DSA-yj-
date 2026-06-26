class Solution {
    public boolean isPalindrome(String s) {
        int left= 0;
        int right = s.length() - 1;
        while(left<right){ 
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left ++ ; //why check again :left<right ?
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right-- ; // forgot to use while
            }
            if(Character.toLowerCase(s.charAt(left)) !=
               Character.toLowerCase(s.charAt(right))) {

                return false;
            }
            left++; // forgot to handle the pointers
            right--;

        }
        return true;
    }
}
/*
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        } 
        int l = sb.length();
        for(int i =0;i<l/2;i++){
            if(sb.charAt(i)!=sb.charAt(l-i-1)){
                return false;
            }
        }
        return true;
    }
}
*/