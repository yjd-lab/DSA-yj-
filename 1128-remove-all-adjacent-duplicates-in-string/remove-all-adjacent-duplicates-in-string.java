import java.util.Stack; // 1. Added required import

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder str = new StringBuilder();
        
        // 2. Fixed parentheses to curly braces here
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stk.isEmpty() && stk.peek() == ch) {
                stk.pop();
            } else {
                stk.push(ch);
            }
        } // 3. Fixed closing brace here
        
        for (char c : stk) {
            str.append(c);
        }

        return str.toString();
    }
}
