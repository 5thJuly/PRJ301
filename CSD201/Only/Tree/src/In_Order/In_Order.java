/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class In_Order {
    public Node Insert(Node t, int x) {
        if(t == null) {
            Node temp = new Node(x);
            temp.data = x;
            temp.left = null;
            temp.right = null;
            return temp;
        }
        else {
            if(x < t.data) {
                t.left = Insert(t.left, x);
            }
            else {
                t.right = Insert(t.right, x);
            }
        }
        return t;
    }
    public void printTree(Node t) {
        if(t != null) {
            printTree(t.left);
            System.out.print(t.data + " ");
            printTree(t.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        In_Order in = new In_Order();
        int n = sc.nextInt();
        Node t = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            t = in.Insert(t, x);
            
        }
        in.printTree(t);
    }
    
}
