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
/*
class Solution {
    public int maxDepth(String s) {
        int max=0;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cnt++;
            }
            else if(s.charAt(i)==')'){
                cnt--;
            }
            max=Math.max(max,cnt);
        }
        return max;
    }
}
*/