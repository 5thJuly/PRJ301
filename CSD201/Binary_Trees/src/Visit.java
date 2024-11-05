

public class Visit {
    public static void printBST(Binary_Search_Tree bst) {
        inorderTraversal(bst.root);
        System.out.println();
    }

    private static void inorderTraversal(Node current) {
        if (current != null) {
            inorderTraversal(current.left);
            System.out.print(current.data + " ");
            inorderTraversal(current.right);
        }
    }
    public static void main(String[] args) {
        Binary_Search_Tree bst = new Binary_Search_Tree();

        // Insert values into the binary search tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Print all elements in the BST
        printBST(bst);
    }


}