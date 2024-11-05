package Q3;

import java.util.NoSuchElementException;

public class Queue {
    private String[] queueArray;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        queueArray = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String x) {
        if (size == queueArray.length) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = x;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        String dequeuedElement = queueArray[front];
        front = (front + 1) % queueArray.length;
        size--;
        return dequeuedElement;
    }

    public String first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return queueArray[front];
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
