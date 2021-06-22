package stack;

import java.util.Stack;

/**
 * 155: MInStack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * Using 2 stacks
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        if(minStack.isEmpty() ||  val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if(!stack.isEmpty()) {
            if(stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(!minStack.isEmpty())
            return minStack.peek();
        return 0;
    }
}
