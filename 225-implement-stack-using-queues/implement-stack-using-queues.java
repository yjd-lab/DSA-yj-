import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>(); 
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int size = q1.size();
        for(int i = 0; i < size - 1; i++){
            q1.add(q1.poll()); 
        }
        return q1.poll(); 
    }
    
    public int top() {
        int size = q1.size();
        for(int i = 0; i < size - 1; i++){
            q1.add(q1.poll());
        }
        int topVal = q1.peek(); 
        q1.add(q1.poll());    
        return topVal;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
