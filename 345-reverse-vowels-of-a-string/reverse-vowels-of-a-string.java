class Solution {
    public String reverseVowels(String s) {
        String  vowels = "AEIOUaeiou";
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;
         while (left<right){
            while(left<right && vowels.indexOf(str[left])==-1){
                left++; //why check left<right again
            }
            while(left<right && vowels.indexOf(str[right])==-1){
                right--;
            }
            char temp = str[left];
            str[left]= str[right];
            str[right]= temp;
            left++;
            right-- ;
    }
    return new String(str);
}}