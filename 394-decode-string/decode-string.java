class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> stk = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num =0;
        for (char i : s.toCharArray()){
            if(Character.isDigit(i)){
                num = num * 10 + (i - '0');
            }else if( i == '['){
                stk.push(num);
                str.push(current);
                current = new StringBuilder();
                num = 0;
            }
            else if( i == ']'){
                int repeat = stk.pop();
                StringBuilder prev = new StringBuilder();
                prev = str.pop();
                for(int j = 0 ; j < repeat ; j++){
                    prev.append(current);
                }
                current = prev;
            }else{
                current.append(i);
            }
        }
        return current.toString();
    }
}