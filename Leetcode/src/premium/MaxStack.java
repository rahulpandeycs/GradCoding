package src.premium;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack = new Stack<>();
    int max = -1;

    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        if(stack.isEmpty()) max = x;

        if(x >= max){
            stack.push(max);
            max = x;
        }

        stack.push(x);

    }

    public int pop() {
        int val = stack.pop();
        if(val == max){
            max = stack.pop();
        }

        return val;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max;
    }

    public int popMax() {
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty() && stack.peek() != max){
            temp.push(stack.pop());
        }

        int temp_max = max;
        this.pop();
        while(!temp.isEmpty()){
            this.push(temp.pop());
        }

        return temp_max;
    }
}
