class Solution {

    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();

        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder current = new StringBuilder();

        int num = 0;

        for(char ch : s.toCharArray()) {

            // digit
            if(Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');
            }

            // opening bracket
            else if(ch == '[') {

                numStack.push(num);

                strStack.push(current);

                current = new StringBuilder();

                num = 0;
            }

            // closing bracket
            else if(ch == ']') {

                int repeat = numStack.pop();

                StringBuilder prev = strStack.pop();

                for(int i = 0; i < repeat; i++) {

                    prev.append(current);
                }

                current = prev;
            }

            // normal character
            else {

                current.append(ch);
            }
        }

        return current.toString();
    }
}