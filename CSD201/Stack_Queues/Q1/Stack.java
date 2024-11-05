package Q1;

import java.util.EmptyStackException;


class Stack {
    private int[] stackArray;
    private int top;

    public Stack(int capacity) {
        stackArray = new int[capacity];
        top = -1;
    }


    public boolean isEmpty() {
        return top == -1;
    }

    public void clean() {
        top = -1;
    }

    public void push(int x) {
        if(top == stackArray.length -1) {
            System.out.println("Stack iz full");
            return;
        }
        stackArray[++top] = x;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException() ;
        }
        return stackArray[top--];
    }
    
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }
    public void visit() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack element: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
            
        }
        System.out.println();
    }
    
}