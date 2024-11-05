
import java.util.ArrayList;
import java.util.List;


public class Cir_LinkedList {
    protected Node head;
    
    
    public Cir_LinkedList() {
        head = null;
    }
    
    public void traverse() {
        Node cur = head;
        do {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        while(cur != head) ;
        System.out.println();
    }
    
    public void addToHead(int x) {
        Node n = new Node(x);
        
        if(head==null) {
            n.next = n;
        }
        else {
            n.next = head;
            Node cur = head;
            while(cur.next !=head) {
                cur = cur.next;
            }
            cur.next  = n;
        }
        head = n;
    }
    public void addToTail(int x) {
        Node n = new Node(x);
        
        if(head == null) {
            n.next = n;
            head = n;
        }
        else {
            n.next = head;
            Node cur = head;
            while(cur.next != head) {
                cur = cur.next;
            }
            cur.next = n;
        }
    }
    public void add_After(Node p, int x) {
        Node n = new Node(x);
        p.next = n;
    }
    public int deleteFromHead() {
        int del = head.data;
        if(head.next == head) {
            head = null;
        }
        else {
            Node cur = head;
            while(cur.next != head) {
                cur = cur.next;
            }
            cur.next = head.next;
            head = head.next;
        }
        return del;
    }
    public int deleteFromTail() {
        int del;
        if(head.next == head) {
            del = head.data;
            head = null;
        }
        else {
            Node cur = head;
            while(cur.next.next != head) {
                cur = cur.next;
            }
            del = cur.next.data;
            cur.next = head;
        }
        return del;
    }
    public int deleteAfter(Node p) {
        int del = p.next.data;
        p.next = p.next.next;
        return del;
        
    }
    public void deleted(int x) {
        if (head.data == x) {
            deleteFromHead();
            return;
        }
        
        Node current = head;
        while (current.next != head) {
            if (current.next.data == x) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        
        System.out.println("Node with value " + x + " not found in the list.");
    }
    public Node search(int x) {
        Node cur = head;
        do {
            if(cur.data == x) {
                return cur;
            }
            cur = cur.next;
        }
        while(cur != head);
        
        System.out.println("Node with value " + x + " not found in the list.");
        return null;
    }
    public int count() {
        int count = 0;
        
        Node cur = head;
        do {
            count++;
            cur = cur.next;
        }
        while(cur != head) ;
        
        return count;
    }
    public void delete(int i) {
        if(i==1) {
            deleteFromHead();
            return;
        }
        Node cur = head;
        Node prev = null;
        int count =1;
        
        do {
            prev = cur;
            cur = cur.next;
            count++;
        }
        while(cur != head && count < i) ;
        
        if(cur == head) {
            System.out.println("Node at position " + i + " does not exist");
            return;
        }
        prev.next = cur.next;
    }
    public void sort() {
        Node cur = head;
        Node index = null;
        int temp;
        
        if(head != null) {
            do {
                index = cur.next;
                while(index != head) {
                    if(cur.data > index.data) {
                        temp = cur.data;
                        cur.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                cur = cur.next;
            }
            while(cur.next != head);
        }
    }
    public void delete(Node p) {
        if(p == head) {
            deleteFromHead();
            return;
        }
        Node cur = head;
        Node prev = null;
        do {
            prev = cur;
            cur = cur.next;
        }
        while(cur != head && cur != p);
        if (cur == head || cur != p) {
            System.out.println("Node p does not exist in the list.");
            return;
        }

        prev.next = cur.next;
    }
    public int[] toArray() {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Node current = head;

        do {
            list.add(current.data);
            current = current.next;
        } while (current != head);

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
    public static Node mergeLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node mergedHead;

        if (head1.data <= head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        Node mergedTail = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                mergedTail.next = head1;
                mergedTail = head1;
                head1 = head1.next;
            } else {
                mergedTail.next = head2;
                mergedTail = head2;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            mergedTail.next = head1;
        } else {
            mergedTail.next = head2;
        }

        return mergedHead;
    }
    public void addBefore(Node p, int x) {
        if (p == null) {
            System.out.println("Node p is null.");
            return;
        }

        Node n = new Node(x);

        if (p == head) {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            n.next = head;
            head = n;
            tail.next = n;
        } else {
            Node current = head;
            while (current.next != p) {
                current = current.next;
            }
            n.next = p;
            current.next = n;
        }
    }

    public void attachList(Cir_LinkedList list) {
        if (head == null) {
            head = list.head;
        } else if (list.head != null) {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = list.head;
            Node listTail = list.head;
            while (listTail.next != list.head) {
                listTail = listTail.next;
            }
            listTail.next = head;
        }
    }
    public int max() {
        int maxVal = head.data;
        Node cur = head.next;
        
        while(cur !=head) {
            if(cur.data > maxVal) {
                maxVal = cur.data;
            }
            cur =  cur.next;
        }
        return maxVal;
    }
    public int min() {
       

        int minVal = head.data;
        Node current = head.next;

        while (current != head) {
            if (current.data < minVal) {
                minVal = current.data;
            }
            current = current.next;
        }

        return minVal;
    }
    public int sum() {
        int sum = head.data;
        Node cur = head.next;
        
        while(cur != head) {
            sum += cur.data;
            cur = cur.next;
        }
        return sum;
    }
    public int avg() {
        int count = count();
        int sum = sum();
        return sum/count;
    }
    public boolean sorted() {
        Node cur = head;
        while(cur.next != head) {
            if(cur.data > cur.next.data) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    public void insert(int x) {
        Node n = new Node(x);

        if (head == null) {
            head = n;
            n.next = n;
            return;
        }

        if (x <= head.data) {
            n.next = head;
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = n;
            tail.next = n;
            return;
        }

        Node current = head;
        while (current.next != head && current.next.data < x) {
            current = current.next;
        }

        n.next = current.next;
        current.next = n;
    }
    public void reverse() {
        Node prev = null;
        Node cur = head;
        Node n = null;
        
        do {
            n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
            
        }
        while(cur != head) ;
        
        head.next = prev;
        head = prev;
    }
    
     public boolean sameContents(Cir_LinkedList list) {
        if (head == null && list.head == null) {
            return true;
        }

        if (head == null || list.head == null) {
            return false;
        }

        Node current1 = head;
        Node current2 = list.head;

        do {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        } while (current1 != head && current2 != list.head);

        return (current1 == head && current2 == list.head);
    }
    

}