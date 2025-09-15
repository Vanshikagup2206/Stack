package Stack;

import java.util.Stack;

public class MinStack {
class MiniStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MiniStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            if (val <= minStack.peek()) {
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        int top = mainStack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */