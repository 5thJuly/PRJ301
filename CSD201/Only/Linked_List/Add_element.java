import java.util.*;

public class Add_element {

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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap so pt cua List: ");
    int n = sc.nextInt();
    System.out.print("Nhap list: ");
    int x = sc.nextInt();
    Node l = createNode(x);
    Node p = l;
    for (int i = 1; i < n; i++) {
      x = sc.nextInt();
      p = addElement(p, x);
    }
    printList(l);
    sc.close();
  }
}
