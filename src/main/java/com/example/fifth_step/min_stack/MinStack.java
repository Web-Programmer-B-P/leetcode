package com.example.fifth_step.min_stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(int value) pushes the element value onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(-2);
        customStack.push(0);
        customStack.push(-3);
        System.out.println(customStack.getMin()); // return -3
        customStack.pop();
        System.out.println(customStack.top());    // return 0
        System.out.println(customStack.getMin()); // return -2

        CustomStackArray customStackArray = new CustomStackArray();
        customStackArray.push(-2);
        customStackArray.push(0);
        customStackArray.push(-3);
        System.out.println(customStackArray.getMin()); // return -3
        customStackArray.pop();
        System.out.println(customStackArray.top());    // return 0
        System.out.println(customStackArray.getMin()); // return -2
        System.out.println(customStackArray.size());

        CustomStackNode customStackNode = new CustomStackNode();
        customStackNode.push(-2);
        customStackNode.push(0);
        customStackNode.push(-3);
        System.out.println(customStackNode.getMin()); // return -3
        customStackNode.pop();
        System.out.println(customStackNode.top());    // return 0
        System.out.println(customStackNode.getMin()); // return -2
    }
}
