/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.LinkedList;
import java.util.Queue;



public class BinarySearchTree {
    protected Node root;

    private class Node {
        private String value;
        private Node left;
        private Node right;

        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Node search(String x) {
        return searchRecursive(root, x);
    }

    private Node searchRecursive(Node current, String x) {
        if (current == null || current.value.equals(x)) {
            return current;
        }

        int compareResult = x.compareTo(current.value);

        if (compareResult < 0) {
            return searchRecursive(current.left, x);
        } else {
            return searchRecursive(current.right, x);
        }
    }

    public void insert(String x) {
        root = insertRecursive(root, x);
    }

    private Node insertRecursive(Node current, String x) {
        if (current == null) {
            return new Node(x);
        }

        int compareResult = x.compareTo(current.value);

        if (compareResult < 0) {
            current.left = insertRecursive(current.left, x);
        } else if (compareResult > 0) {
            current.right = insertRecursive(current.right, x);
        }

        return current;
    }

    public void breadth() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        System.out.println();
    }

    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.value + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.value + " ");
            inorder(p.right);
        }
    }

    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.value + " ");
        }
    }

    public int count() {
        return countRecursive(root);
    }

    private int countRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        return 1 + countRecursive(current.left) + countRecursive(current.right);
    }

    public void dele(String x) {
        root = deleteRecursive(root, x);
    }

    private Node deleteRecursive(Node current, String x) {
        if (current == null) {
            return null;
        }

        int compareResult = x.compareTo(current.value);

        if (compareResult < 0) {
            current.left = deleteRecursive(current.left, x);
        } else if (compareResult > 0) {
            current.right = deleteRecursive(current.right, x);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                Node successor = findMinNode(current.right);
                current.value = successor.value;
                current.right = deleteRecursive(current.right, successor.value);
            }
        }

        return current;
    }

    private Node findMinNode(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node min() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node max() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public int sum() {
        return sumRecursive(root);
    }

    private int sumRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        return Integer.parseInt(current.value) + sumRecursive(current.left) + sumRecursive(current.right);
    }

    public int avg() {
        int count = count();
        if (count == 0) {
            return 0;
        }

        return sum() / count;
    }

    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = heightRecursive(current.left);
        int rightHeight = heightRecursive(current.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int mostExpensivePathCost() {
        return mostExpensivePathCostRecursive(root);
    }

    private int mostExpensivePathCostRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        int leftPathCost = mostExpensivePathCostRecursive(current.left);
        int rightPathCost = mostExpensivePathCostRecursive(current.right);

        return Integer.parseInt(current.value) + Math.max(leftPathCost, rightPathCost);
    }

    public boolean isAVL() {
        return isAVLRecursive(root);
    }

    private boolean isAVLRecursive(Node current) {
        if (current == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(current);
        if (balanceFactor > 1 || balanceFactor < -1) {
            return false;
        }

        return isAVLRecursive(current.left) && isAVLRecursive(current.right);
    }

    private int getBalanceFactor(Node current) {
        int leftHeight = heightRecursive(current.left);
        int rightHeight = heightRecursive(current.right);
        return leftHeight - rightHeight;
    }

    public boolean isHeap() {
        return isHeapRecursive(root);
    }

    private boolean isHeapRecursive(Node current) {
        if (current == null) {
            return true;
        }

        if (current.left != null && current.value.compareTo(current.left.value) < 0) {
            return false;
        }

        if (current.right != null && current.value.compareTo(current.right.value) < 0) {
            return false;
        }

        return isHeapRecursive(current.left) && isHeapRecursive(current.right);
    }
}

