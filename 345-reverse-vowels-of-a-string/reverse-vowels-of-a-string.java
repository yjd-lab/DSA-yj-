class Solution {
    public String reverseVowels(String s) {

        char[] str = s.toCharArray();

        String vowels = "AEIOUaeiou";

        int start = 0;
        int end = s.length() - 1;

        while(start < end) {

            while(start < end && vowels.indexOf(str[start]) == -1) {
                start++;
            }

            while(start < end && vowels.indexOf(str[end]) == -1) {
                end--;
            }

            char ch = str[start];
            str[start] = str[end];
            str[end] = ch;

            start++;
            end--;
        }

        return new String(str);
    }
}