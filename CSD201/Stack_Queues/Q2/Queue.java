package Q2;

import java.util.NoSuchElementException;

public class Queue {
    
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;
    
    public Queue(int capacity) {
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clean() {
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(int x) {
        if (size == queueArray.length) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear +1) % queueArray.length;
        queueArray[rear] = x;
        size++;
    }

    public int dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int x = queueArray[front];
        front = (front+1) % queueArray.length;
        size--;
        return x;
    }
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int count = 0;
        int index = front;
        while (count < size) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % queueArray.length;
            count++;
        }
        System.out.println();
    }   
}
