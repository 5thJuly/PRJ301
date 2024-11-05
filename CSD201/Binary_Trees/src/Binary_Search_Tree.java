
import java.util.LinkedList;
import java.util.Queue;


public class Binary_Search_Tree {
    protected Node root;

    public Binary_Search_Tree() {
        this.root = null;
    }
    public boolean isEmpty() {
        return root == null;
        
    }
    public void clear() {
        root = null;
    }
    public Node search(int x) {
        return searchRecursive(root, x);
    }

    private Node searchRecursive(Node current, int x) {
        if (current == null || current.data == x) {
            return current;
        }

        if (x < current.data) {
            return searchRecursive(current.left, x);
        }

        return searchRecursive(current.right, x);
    }

    public void insert(int x) {
        root = insertRecursive(root, x);
    }
    public void visit(Node p) {
        
    }

    private Node insertRecursive(Node current, int x) {
        if (current == null) {
            return new Node(x);
        }

        if (x < current.data) {
            current.left = insertRecursive(current.left, x);
        } else if (x > current.data) {
            current.right = insertRecursive(current.right, x);
        }

        return current;
    }

    public void breadth() {
        if (root == null) {
            System.out.println("The tree is empty.");
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        System.out.println();
    }
    
    

    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.data + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);
        }
    }

    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data + " ");
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

    public void dele(int x) {
        root = deleteRecursive(root, x);
    }

    private Node deleteRecursive(Node current, int x) {
        if (current == null) {
            return null;
        }

        if (x < current.data) {
            current.left = deleteRecursive(current.left, x);
        } else if (x > current.data) {
            current.right = deleteRecursive(current.right, x);
        } else {
            // Node to delete found

            // Case 1: No child or one child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Case 2: Two children
            current.data = findMinValue(current.right);
            current.right = deleteRecursive(current.right, current.data);
        }

        return current;
    }

    private int findMinValue(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public Node min() {
        return findMinNode(root);
    }

    private Node findMinNode(Node current) {
        if (current == null || current.left == null) {
            return current;
        }
        return findMinNode(current.left);
    }

    public Node max() {
        return findMaxNode(root);
    }

    private Node findMaxNode(Node current) {
        if (current == null || current.right == null) {
            return current;
        }
        return findMaxNode(current.right);
    }

    public int sum() {
        return sumRecursive(root);
    }

    private int sumRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        return current.data + sumRecursive(current.left) + sumRecursive(current.right);
    }

    public int avg() {
        int sum = sum();
        int count = count();

        if (count != 0) {
            return sum / count;
        }

        return 0;
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

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int mostExpensivePathCost() {
        return mostExpensivePathCostRecursive(root);
    }

    private int mostExpensivePathCostRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        int leftCost = mostExpensivePathCostRecursive(current.left);
        int rightCost = mostExpensivePathCostRecursive(current.right);

        return current.data + Math.max(leftCost, rightCost);
    }

    public boolean isAVL() {
        return isAVLRecursive(root);
    }

    private boolean isAVLRecursive(Node current) {
        if (current == null) {
            return true;
        }

        int balanceFactor = calculateBalanceFactor(current);

        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isAVLRecursive(current.left) && isAVLRecursive(current.right);
    }

    private int calculateBalanceFactor(Node current) {
        int leftHeight = heightRecursive(current.left);
        int rightHeight = heightRecursive(current.right);

        return leftHeight - rightHeight;
    }

    public int mystery(Node x) {
        if (x == null)
            return 0;
        else
            return Math.max(mystery(x.left), mystery(x.right));
    }

    public boolean isHeap() {
        return isHeapRecursive(root);
    }

    private boolean isHeapRecursive(Node current) {
        if (current == null) {
            return true;
        }

        if (current.left != null && current.left.data > current.data) {
            return false;
        }

        if (current.right != null && current.right.data > current.data) {
            return false;
        }

        return isHeapRecursive(current.left) && isHeapRecursive(current.right);
    }
}
    
    
