/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;


public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values into the binary search tree
        bst.insert("apple");
        bst.insert("banana");
        bst.insert("cherry");
        bst.insert("date");
        bst.insert("elderberry");
        bst.insert("fig");
        bst.insert("grape");

        // Perform various operations
        System.out.println("Is the tree empty? " + bst.isEmpty());
        System.out.println("Number of nodes in the tree: " + bst.count());
        System.out.println("Inorder traversal:");
        bst.inorder(bst.root);
        System.out.println();
        System.out.println("Height of the tree: " + bst.height());
        System.out.println("Cost of the most expensive path: " + bst.mostExpensivePathCost());
        System.out.println("Is the tree AVL? " + bst.isAVL());
        System.out.println("Is the tree a heap? " + bst.isHeap());

        // Delete a node from the tree
        bst.dele("banana");

        // Print the tree after deletion
        System.out.println("Inorder traversal after deletion:");
        bst.inorder(bst.root);
        System.out.println();
    }
}
