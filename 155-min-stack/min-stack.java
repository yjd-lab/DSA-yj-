class MinStack {

    Stack<Integer> stk;
    Stack<Integer> minstk;

    public MinStack() {

        stk = new Stack<>();
        minstk = new Stack<>();
    }
    
    public void push(int val) {

        stk.push(val);

        if(!minstk.isEmpty()) {

            val = Math.min(val, minstk.peek());
        }

        minstk.push(val);
    }
    
    public void pop() {

        stk.pop();
        minstk.pop();
    }
    
    public int top() {

        return stk.peek();
    }
    
    public int getMin() {

        return minstk.peek();
    }
}