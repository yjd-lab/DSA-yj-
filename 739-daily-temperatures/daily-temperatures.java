class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stk = new Stack<>();

        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {

            while(!stk.isEmpty() &&
                  temperatures[i] > temperatures[stk.peek()]) {

                int prevIndex = stk.pop();

                result[prevIndex] = i - prevIndex; //important
            }

            stk.push(i);
        }

        return result;
    }
}