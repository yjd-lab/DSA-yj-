import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stk.push(ch);
            } 
            else {
                // If stack is empty, there is no matching opening bracket
                if (stk.isEmpty()) {
                    return false;
                }
                char top = stk.pop();
                if (ch == ']' && top != '[') return false;
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
            }
        }
        // String is valid only if all brackets found their match
        return stk.isEmpty();
    }
}
