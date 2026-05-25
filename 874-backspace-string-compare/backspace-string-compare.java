class Solution {

    public boolean backspaceCompare(String s, String t) {

        return build(s).equals(build(t));
    }

    public String build(String str) {

        StringBuilder string = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) != '#') {
                string.append(str.charAt(i));
            }

            else if(string.length() > 0) {
                string.deleteCharAt(string.length() - 1);
            }
        }

        return string.toString();
    }
}