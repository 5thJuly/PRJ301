import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
}

class Main {
    public static Node insert(Node t, int x) {
        if (t == null) {
            Node temp = new Node();
            temp.data = x;
            temp.left = null;
            temp.right = null;
            return temp;
        } else {
            if (x < t.data) {
                t.left = insert(t.left, x);
            } else {
                t.right = insert(t.right, x);
            }
            return t;
        }
    }

    public static int getDepth(Node t) {
        if (t == null) return 0;
        int leftDepth = getDepth(t.left);
        int rightDepth = getDepth(t.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node t = null;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            t = insert(t, temp);
        }
        int depth = getDepth(t);
        System.out.println(depth);
    }
}
