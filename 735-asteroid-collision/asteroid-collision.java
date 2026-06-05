class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stk = new Stack<>();

        for(int ch : asteroids) {

            if(ch > 0) {

                stk.push(ch);
            }

            else {

                while(!stk.isEmpty() &&
                      stk.peek() > 0 &&
                      stk.peek() < Math.abs(ch)) {

                    stk.pop();
                }

                if(stk.isEmpty() || stk.peek() < 0) {

                    stk.push(ch);
                }

                else if(stk.peek() == Math.abs(ch)) {

                    stk.pop();
                }
            }
        }

        int[] result = new int[stk.size()];

        for(int i = result.length - 1; i >= 0; i--) {

            result[i] = stk.pop();
        }

        return result;
    }
}