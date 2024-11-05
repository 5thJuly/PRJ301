import java.util.*;

public class Showing_Node {
    static class Node {

        int data;
        Node next;
    
        public Node(int data) {
          this.data = data;
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
    static Node getNode(Node l, int k) {
        Node p = l;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        return p;
    }
    public static void main(String[] args) {
      int n,x,k;
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      x = sc.nextInt();
      Node l = createNode(x);
      Node p = l;
      for (int i = 0; i < n; i++) {
        x = sc.nextInt();
        p = addElement(p, x);
      }
      k = sc.nextInt();
      p = getNode(l, k);
      System.out.println(p.data);
      sc.close();
    }
    
}
