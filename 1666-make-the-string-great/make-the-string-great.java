import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        Stack<Character> stk = new Stack<>();
        for (char i : s.toCharArray()) {
            // Use an if statement instead of a while loop
            if (!stk.isEmpty() && Math.abs(i - stk.peek()) == 32) {
                stk.pop();
            } else {
                stk.push(i);
            }
        }
        
        // Build the string from the remaining characters in the stack
        StringBuilder str = new StringBuilder();
        for (char ch : stk) {
            str.append(ch);
        }
        return str.toString();
    }
}
