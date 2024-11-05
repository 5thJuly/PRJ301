package Q4;

import java.util.EmptyStackException;

public class Stack {
    private char[] stackArray;
    private int top;

    public Stack(int capacity) {
        stackArray = new char[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void clear() {
        top = -1;
    }

    public void push(char x) {
        if (top == stackArray.length - 1) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stackArray[++top] = x;
    }

    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public char top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}
