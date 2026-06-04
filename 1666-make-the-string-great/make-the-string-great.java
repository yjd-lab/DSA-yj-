class Solution {

    public String makeGood(String s) {

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(!stk.isEmpty() &&
               Math.abs(stk.peek() - ch) == 32) {

                stk.pop();
            }

            else {

                stk.push(ch);
            }
        }

        StringBuilder str = new StringBuilder();

        for(char c : stk) {
            str.append(c);
        }

        return str.toString();
    }
}