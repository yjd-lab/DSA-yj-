import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        // You must compare the built version of BOTH strings
        return build(s).equals(build(t));
    }
    
    // Changed return type from boolean to String
    public String build(String str) {
        Stack<Character> stk = new Stack<>();
        for (char i : str.toCharArray()) { // Fixed variable name to use 'str'
            // Only pop if the stack is not empty AND the current character is '#'
            if (i == '#') {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else {
                stk.push(i);
            }
        }
        
        // Convert the stack back into a String to return it
        StringBuilder result = new StringBuilder();
        for (char ch : stk) {
            result.append(ch);
        }
        return result.toString();
    }
}
