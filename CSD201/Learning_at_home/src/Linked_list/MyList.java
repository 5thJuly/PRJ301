/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_list;

/**
 *
 * @author Admin
 */
public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        return head == null;
    }
    void display() {
        Node current = head;
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    void addFirst(int value) {
        Node n = new Node(value);
        if(isEmpty()) {
            head = tail = n;
        }
        else {
            n.next = head;
            head = n;
        }
    }
    void addLast(int value) {
        Node n = new Node(value);
        if(isEmpty()) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail=n;
        }
    }
    void addIndex(int value, int index) {
        if(index < 0) {
            return;
        }
        if(index == 0) {
            addFirst(value);
        }
        else {
            Node current = head;
            int pos = 0;
            while(current !=null) {
                if(index-1 == pos) break;
                current = current.next;
                pos++;
            }
            if(current ==null) {
                return;
            }
            else {
                Node n = new Node(value);
                if(current.next == null) {
                    addLast(value);
                }
                n.next = current.next;
                current.next = n;
            }
            
        }
    }
    
    boolean isPrime(int value) {
        if(value <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(value); i++) {
            if(value % i ==0) {
                return false;
            }
            
        }
        return true;
    }
    
    public static void main(String[] args) {
        MyList m = new MyList();
        
        
        
        m.addFirst(6);
        m.addFirst(5);
        m.addFirst(4);
        
        m.addFirst(3);
        m.addFirst(2);
        m.addFirst(1);
        m.addFirst(0);
        m.display();
        
        System.out.println("============================");
        m.addLast(29);
        m.addLast(23);
        m.display();
        System.out.println("============================");
        m.addIndex(20,3);
        m.display();
    }
    
    
}
