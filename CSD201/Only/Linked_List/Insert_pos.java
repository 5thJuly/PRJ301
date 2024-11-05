import java.util.*;

public class Insert_pos {
    static class Node {

        int data;
        Node next;
    
        public Node(int x) {
          this.data = x;
          next = null;
        }
      }
    
    static Node createNode(int x) {
        Node temp = new Node(x);
        return temp;
    }
    static void printList(Node l) {
        Node p = l;
        while (p != null) {
          System.out.print(p.data + " ");
          p = p.next;
        }
    }
    
    static Node addElement(Node p, int x) {
        Node temp = createNode(x);
        p.next = temp;
        return temp;
    }
    static Node add_Position(Node l, int k, int x) {
        Node p = l;
        for (int i = 0; i < k-1; i++) {
            p = p.next;
        }
        Node temp = new Node(x);
        
        temp.next = p.next;
        p.next = temp;

        return l;
    }
    static Node add_First(Node l, int x) {
        Node temp = new Node(x);
        
        temp.next = l;
        
        return temp;
    }
    static Node add_Last(Node l, int x) {
        Node p = l;
        while(p.next != null) {
            p = p.next;
        }
        Node temp = new Node(x);
        
        p.next = temp;
        temp.next=null;
        return l;
        
    }
    public static void main(String[] args) {
        int n,x,k;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so pt cua List: ");
        n = sc.nextInt();
        System.out.print("Insert value: ");
        x = sc.nextInt();
        Node l = createNode(x);
        Node p = l;
        for (int i = 0; i < n; i++) {
            System.out.print("Insert list: ");
            x = sc.nextInt();
            p.next = addElement(p, x);
            p = p.next;

        }
        System.out.print("Input postion: ");
        k = sc.nextInt();
        System.out.print("Input number of Node: ");
        x = sc.nextInt();
        if(k==0){
            l = add_First(l, x);
        }
        else if(k ==n) {
            l = add_Last(l, x);
        }
        else{
            l = add_Position(l, k, x);
        }
        printList(l);
        sc.close();
    }
}
