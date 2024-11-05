

public class Main {

    public static void main(String[] args) {
        Binary_Search_Tree b = new Binary_Search_Tree();
        
        b.insert(50);
        b.insert(30);
        b.insert(20);
        b.insert(10);
        b.insert(60);
        b.insert(90);
        b.insert(100);
        b.insert(230);
        b.insert(110);
        
     
        
        
        
        
        System.out.println("Is the tree empty? " + b.isEmpty());
        System.out.println("======================================");
        
        System.out.println("Number of nodes in the tree: " + b.count());
        System.out.println("======================================");

        System.out.println("Preorder traversal:");
        b.preorder(b.root);
        System.out.println();
        System.out.println("======================================");

        System.out.println("Inorder traversal:");
        b.inorder(b.root);
        System.out.println();
        System.out.println("======================================");

        System.out.println("Postorder traversal:");
        b.postorder(b.root);
        System.out.println();
        System.out.println("======================================");

        System.out.println("Breadth-first traversal:");
        b.breadth();
        System.out.println();
        System.out.println("======================================");

        System.out.println("Searching for value 40:");
        Node foundNode = b.search(40);
        if (foundNode != null) {
            System.out.println("Node found: " + foundNode.data);
        } else {
            System.out.println("Node not found.");
        }

        System.out.println("Deleting node with value 30:");
        b.dele(30);
        System.out.println("Inorder traversal after deletion:");
        b.inorder(b.root);
        System.out.println();
        System.out.println("======================================");

        System.out.println("Minimum value in the tree: " + b.min().data);

        System.out.println("======================================");

        System.out.println("Maximum value in the tree: " + b.max().data);
        
        System.out.println("======================================");

        
        System.out.println("Sum of all values in the tree: " + b.sum());
        
        System.out.println("======================================");
        
        System.out.println("Average of all values in the tree: " + b.avg());
        
        System.out.println("======================================");
        
        System.out.println("Height of the tree: " + b.height());
        
        System.out.println("======================================");
        
        System.out.println("Cost of the most expensive path: " + b.mostExpensivePathCost());
        
        System.out.println("======================================");
        
        System.out.println("Is the tree AVL? " + b.isAVL());
        
        System.out.println("======================================");
        
        System.out.println("Is the tree a heap? " + b.isHeap());

        // Clear the binary search tree
        b.clear();
        System.out.println("Is the tree empty after clearing? " + b.isEmpty());
    
        
        
    }
}
