class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < operations.length; i++) {

            String ch = operations[i]; // beacuse the elements in the list are string

            if(!ch.equals("+") &&   // this is how u compare stringss
               !ch.equals("D") &&
               !ch.equals("C")) {

                stk.push(Integer.parseInt(ch));
            }

            else {

                switch(ch) {

                    case "+":

                        int top1 = stk.pop();
                        int top2 = stk.pop();

                        int newScore = top1 + top2;

                        stk.push(top2);
                        stk.push(top1);
                        stk.push(newScore);

                        break;

                    case "D":

                        stk.push(stk.peek() * 2);

                        break;

                    case "C":

                        stk.pop();

                        break;
                }
            }
        }

        int sum = 0;

        while(!stk.isEmpty()) {
            sum += stk.pop();
        }

        return sum;
    }
}