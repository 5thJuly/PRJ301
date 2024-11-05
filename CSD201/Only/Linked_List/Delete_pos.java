import java.util.Scanner;

class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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

    static Node deleteHead(Node l) {
        Node p = l;
        p = p.next;
        l = null;
        return p;
    }

    static Node deleteTail(Node l) {
        Node p = l;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return l;
    }

    static Node deleteAt(Node l, int k) {
        Node p = l;
        for (int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        Node temp = p.next;
        p.next = p.next.next;
        temp = null;
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, x, k;
        System.out.print("Nhap so pt cua List: ");
        n = sc.nextInt();
        System.out.print("So vi tri can xoa : ");
        x = sc.nextInt();
        Node l = createNode(x);
        Node p = l;
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + i + ": ");
            x = sc.nextInt();
            p = addElement(p, x);
        }
        System.out.print("Nhap vi tri can delete: ");
        k = sc.nextInt();
        if (k == 0) {
            l = deleteHead(l);
        } else if (k == n - 1) {
            l = deleteTail(l);
        } else {
            l = deleteAt(l, k);
        }
        printList(l);
        sc.close();
    }
}
