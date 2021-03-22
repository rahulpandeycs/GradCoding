package src;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> stck;
    int max;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stck = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (x >= max) {
            stck.push(max);
            max = x;
        }
        stck.push(x);
    }

    public int pop() {
        if (!stck.isEmpty()) {
            int val = stck.pop();
            if (val == max) {
                max = stck.pop();
            }
            return val;
        }
        return -1;
    }

    public int top() {
        return stck.peek();
    }

    public int peekMax() {
        return max;
    }

    public int popMax() {
        Stack<Integer> tempStack = new Stack<>();

        while (!stck.isEmpty() && stck.peek() != max) {
            tempStack.push(stck.pop());
        }
        int tempMax = this.pop();

        while (!tempStack.isEmpty()) {
            stck.push(tempStack.pop());
        }
        return tempMax;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
