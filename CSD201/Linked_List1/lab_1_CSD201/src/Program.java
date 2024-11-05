import java.util.*;


public class Program {
    Node head;
    int size;

    public Program() {
        head = null;
        size = 0;
    }
    
    boolean isEmpty() {
        return head == null;
    }
    void clean() {
        head = null;
    }
    
    // 4. void traverse() - traverse from head to tail and dislay data of all nodes in the list
    public void traverse() {
        Node p  =head;
        System.out.print("List: ");
        while(p!=null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    // 1. void addToHead(int x) - add a node with value x at the head of a list.
    public void add_First(int x) {
        Node n = new Node(x); 
        if(head == null) {
            head = n;
        }
        else {
            n.next = head;
            head = n;
        }
        size++;
    }
    // 2. void add_Last(int x) - add a node with value x at the tail of a list.
    public void add_Last(int x) {
        Node n = new Node(x); 
        if(head == null) {
            head = n;
        }
        else { 
            Node cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = n;
        }
        size++;
    }
    // 3. void addAfter(Node p, int x) - add a node with value x after the node p.
    public void add_After(Node p, int x) {
        Node n = new Node(x);
        n.next = p.next;
        p.next = n;
        size++;
    }
    
    
    
    // 5. int deleteFromHead() - delete the head and return its data.
    public int deleteFromHead() {
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    //6. int deleteFromTail() - delete the tail and return its data.
    public int deleteFromTail() {
        if(head.next == null) {
            int x = head.data;
            head = null;
            size--;
            return x;
        }
        Node cur = head;
        while(cur.next.next != null) {
            cur = cur.next;
        }
        int data = cur.next.data;
        cur.next = null;
        size--;
        return data; 
    }
    // 7. int deleteAter(Node p) - delete the node after the node p and return its data.
    public int deleteAfter(Node p) {
        
        int data = p.next.data;
        p.next = p.next.next;
        size--;
        return data;
    }
    // 8. void dele(int x) - delele the first node whose data is equal to x.
    public void delete(int x) {
        if(head.data == x) {
            head = head.next;
            size--;
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.data != x) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
            size--;
        }
    }
    // 9. Node search(int x) - search and return the reference to the first node having data x.
    public Node search(int x) {
        Node cur = head;
        while(cur != null && cur.data != x) {
            cur = cur.next;
        }
        return cur;
    }
    //10. int count() - count and return number of nodes in the list.
    public int count() {
        return size;
    }
    // 11. void dele(int i) - delete an i-th node on the list. Besure that such a node exists.
    public void del(int i) {
        if (i < 1 || i > size) {
            throw new IllegalArgumentException("Invalid index");
        }

        if (i == 1) {
            head = head.next;
            size--;
            return;
        }

        Node cur = head;
        int index = 1;
        while (cur.next != null && index < i - 1) {
            cur = cur.next;
            index++;
        }

        if (cur.next == null) {
            throw new RuntimeException("Index out of bounds");
        }

        cur.next = cur.next.next;
        size--;
    }
    
    // 12. void sort() - sort the list by ascending order of data
    public void sort() {
       
        Node cur = head;
        while (cur != null) {
            Node minNode = cur;
            Node temp = cur.next;

            while (temp != null) {
                if (temp.data < minNode.data) {
                    minNode = temp;
                }
                temp = temp.next;
            }

            int tempData = cur.data;
            cur.data = minNode.data;
            minNode.data = tempData;

            cur = cur.next;
        }
    }
    // 13. void dele(Node p) - delete node p if it exists in the list.
    public void delete_N(Node p) {
        if(head == null) {
            head = head.next;
            return;
        }
        Node cur = head;
        while(cur != null && cur.next != p) {
            cur = cur.next;
        }
        if(cur != null) {
            cur.next = cur.next.next;
        }
    }
    
    // 14. int [] toArray() - create and return array containing data of all nodes in the list
    public int[] toArray() {
        int[] a = new int[count()];
        Node curr = head;
        int i = 0;
        while (curr != null) {
            a[i++] = curr.data;
            curr = curr.next;
        }
        return a;
    }
    // 15. Merge two ordered singly linked lists of integers into one ordered list.
    public static Program merge(Program list1, Program list2) {
        Program g = new Program();
        Node curr1 = list1.head;
        Node curr2 = list2.head;
        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                g.add_Last(curr1.data);
                curr1 = curr1.next;
            } else {
                g.add_Last(curr2.data);
                curr2 = curr2.next;
            }
        }
        while (curr1 != null) {
            g.add_Last(curr1.data);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            g.add_Last(curr2.data);
            curr2 = curr2.next;
        }
        return g;
    }
    // 16. void addBefore(Node p, int x) - add a node with value x before the node p.
    public void addBefore(Node p, int x) {
        if (head == null) {
            return;
        }
        if (head == p) {
            add_First(x);
            return;
        }
        Node curr = head;
        while (curr != null && curr.next != p) {
            curr = curr.next;
        }
        if (curr != null) {
            Node n = new Node(x, curr.next);
            curr.next = n;
        }
    }
    //17. Attach a singly linked list to the end of another singly linked list.
    public void attach(Program list) {
        if (head == null) {
            head = list.head;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = list.head;
        }
    }
    // 18. int max() - find and return the maximum value in the list.
    public int max() {
        int max = head.data;
        Node cur = head.next;
        while(cur != null) {
            if(cur.data > max) {
                max = cur.data;
            }
            cur = cur.next;
        }
        return max;
    }
    // 19. int min() - find and return the minimum value in the list.
    public int min(){
        int min = head.data;
        Node cur = head.next;
        while(cur != null) {
            if(cur != null) {
                min = cur.data;
            }
            cur = cur.next;
        }
        return min;
    }
    
    //20. int sum() - return the sum of all values in the list.
    public int sum() {
        int sum = 0;
        Node cur = head;
        while(cur != null) {
            sum += cur.data;
            cur = cur.next;
        }
        return sum;
    }
    // 21. int avg() - return the average of all values in the list.
    public int avg() {
        return sum()/size;
    }

//22. boolean sorted() - check and return true if the list is sorted, return false if the list is not sorted.
    
    public boolean sorted() {
        Node cur = head;
        while(cur.next != null) {
            if(cur.data > cur.next.data) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
//23. void insert(int x) - insert node with value x into sorted list so that the new list is sorted.
    public void insert(int x) {
        Node n = new Node(x);
        if(head == null || head.data >= x) {
            n.next = head;
            head = n;
            size++;
            return;
        }
        Node cur = head;
        while(cur.next != null && cur.next.data < x) {
            cur = cur.next;
        }
        n.next = cur.next;
        cur.next = n;
        size++;
    }
//24. Reverse a singly linked list using only one pass through the list.
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
//25. Check whether two singly linked list have the same contents.
    public boolean equals(Program p) {
        if(size != p.size) {
            return false;
        }
        Node cur = head;
        Node oCur = p.head;
        while(cur != null && oCur != null) {
            if(cur.data != oCur.data) {
                return false;
            }
            cur = cur.next;
            oCur = oCur.next;
        }
        return true;
    }
}





// That's it