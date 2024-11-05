import java.util.Scanner;

class Node {
    int data;
    Node next;
 
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
 
class LinkedList {
    Node head;
 
    public LinkedList() {
        head = null;
    }
 
    // Thêm phần tử vào cuối danh sách liên kết đơn
    public void addLast(int data) {
        Node newNode = new Node(data);
 
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
 
    // Thay đổi giá trị của những phần tử có giá trị a thành giá trị b
    public void replace(int a, int b) {
        Node current = head;
        while (current != null) {
            if (current.data == a) {
                current.data = b;
            }
            current = current.next;
        }
    }
 
    // In danh sách liên kết đơn ra màn hình
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
 
public class Convert_Node {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        LinkedList list = new LinkedList();
 
        // Nhập dữ liệu vào danh sách liên kết đơn
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.addLast(data);
        }
 
        int a = sc.nextInt();
        int b = sc.nextInt();
 
        // Thay đổi giá trị của phần tử có giá trị a thành giá trị b
        list.replace(a, b);
 
        // In danh sách liên kết đơn ra màn hình
        list.printList();
        sc.close();
    }
}
