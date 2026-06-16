import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        // Changed Stack type from Integer to Character
        Stack<Character> stk = new Stack<>();
        for (char i : s.toCharArray()) {
            if (!stk.isEmpty() && i == stk.peek()) {
                stk.pop();
            } else {
                stk.push(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : stk) {
            result.append(ch);
        }
        return result.toString();
    }
}
