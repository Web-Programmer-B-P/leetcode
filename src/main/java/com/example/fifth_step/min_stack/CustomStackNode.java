package com.example.fifth_step.min_stack;

import java.util.EmptyStackException;

public class CustomStackNode {
    private static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Node head;

    public CustomStackNode() {
    }

    public void push(int value) {
        if (head == null) {
            head = new Node(value, value);
        } else {
            Node curr = new Node(value, Math.min(value, head.min));
            curr.next = head;
            head = curr;
        }
    }

    public void pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        head = head.next;
    }

    public int top() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.val;
    }

    public int getMin() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.min;
    }

    public boolean isEmpty() {
        return head == null;
    }
}