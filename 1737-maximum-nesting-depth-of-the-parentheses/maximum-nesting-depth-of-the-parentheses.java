class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int res=0;
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                stk.push(ch);
                count++;
            }
            if(ch==')'){
                stk.pop();
                
                res = Math.max(res,count);
                count--;
            }
        }
        return res;
    }
}