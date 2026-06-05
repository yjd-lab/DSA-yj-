class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        
        // Declare variables outside the switch to avoid duplicate errors
        int top1, top2, temp;

        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+": // Use double quotes for Strings
                    top1 = stk.pop();
                    top2 = stk.pop();
                    temp = top2 + top1; // Pop order matters for clarity
                    stk.push(temp);
                    break;
                case "-":
                    top1 = stk.pop();
                    top2 = stk.pop();
                    temp = top2 - top1;
                    stk.push(temp);
                    break;
                case "/":
                    top1 = stk.pop();
                    top2 = stk.pop();
                    temp = top2 / top1;
                    stk.push(temp);
                    break;
                case "*": // Removed the duplicate case "/"
                    top1 = stk.pop();
                    top2 = stk.pop();
                    temp = top2 * top1;
                    stk.push(temp);
                    break;
                default: // If it is not an operator, it must be a number
                    stk.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stk.pop();
    }
}
