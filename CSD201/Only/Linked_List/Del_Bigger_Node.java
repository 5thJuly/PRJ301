import java.util.Scanner;



public class Del_Bigger_Node {
    static class Node {
        int data;
        Node next;
    
        Node(int x) {
            data = x;
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
    static Node del_Bigger(Node l, int k) {
        Node p = l;
        Node ans = new Node(-1);
        while(p != null) {
            if(p.data <= k) {
                ans = new Node(p.data);
                p = p.next;
                break;
            }
            p = p.next;
        }
        while(p != null) {
            if(p.data <= k) {
                ans = add_Last(ans, p.data);
            }
            p = p.next;

        }
        return ans;
    
    }
    static Node getNode(Node l, int k) {
        Node p = l;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        return p;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        Node l = new Node(x);
        Node p = l;
        for (int i = 1; i < n; i++) {
            x = sc.nextInt();
            p = addElement(p, x);
        }
        int k = sc.nextInt();
        l = del_Bigger(l, getNode(l, k).data);
        printList(l);
        sc.close();
    }
}
