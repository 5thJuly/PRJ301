package q1_pe;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class MyQueue {
    LinkedList<BSTNode> t;

    MyQueue() {
        t = new LinkedList<>();
    }

    boolean isEmpty() {
        return t.isEmpty();
    }

    void enqueue(BSTNode p) {
        t.addLast(p);
    }

    BSTNode dequeue() {
        if (isEmpty()) return (null);        
        return t.removeFirst();
    }

    BSTNode front() {
        if (isEmpty()) return (null);       
        return t.getFirst();
    }
}
