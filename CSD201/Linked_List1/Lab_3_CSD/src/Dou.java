
public class Dou {
    protected Node head;
    protected Node tail;
    int size;
    
    
    
    public void traverse() {
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    
    
    public void addtoHead(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }
    public void addToTail(int x) {
        Node n = new Node(x);
        
        if(tail == null) {
            head = n;
            tail = n;
        }
        else {
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
        size++;
    }
    public void addAfter(Node p, int x) {
        Node n = new Node(x);
        n.prev = p;
        n.next = p.next;
        
        if(p.next != null) {
            p.next.prev = n;
        }
        p.next = n;
        if(p == tail) {
            tail = n;
        }
        size++;
    }
    public int deleteFromHead() {
        int a = head.data;
        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
        return a;
    }
    public int deleteFromTail() {
        int a = tail.data;
        if(head == tail) {
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        
        return a;
    }
    public int deleteAfter(Node p) {
        Node n = p.next;
        int del = n.data;
        
        p.next = n.next;
        if(n.next != null) {
            n.next.prev = p;
        }
        if(n == tail) {
            tail = p;
        }
        size--;
        return del;
    }
     public void deleted(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                if (current == head) {
                    deleteFromHead();
                } else if (current == tail) {
                    deleteFromTail();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
        }
    }
     public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x)
                return current;
            current = current.next;
        }
        return null;
    }

    public int count() {
        return size;
    }
    public void delete(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Invalid index.");

        if (i == 0) {
            deleteFromHead();
        } else if (i == size - 1) {
            deleteFromTail();
        } else {
            Node current = head;
            int count = 0;
            while (count < i) {
                current = current.next;
                count++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void sort() {
        if (size <= 1)
            return;

        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            while (nextNode != null) {
                if (current.data > nextNode.data) {
                    int temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            current = current.next;
        }
    }

    public void delete(Node p) {
        if (p == null)
            return;

        if (p == head) {
            deleteFromHead();
        } else if (p == tail) {
            deleteFromTail();
        } else {
            p.prev.next = p.next;
            p.next.prev = p.prev;
            size--;
        }
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index] = current.data;
            current = current.next;
            index++;
        }
        return array;
    }

    public static Dou mergeLists(Dou list1, Dou list2) {
        Dou d = new Dou();

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                d.addToTail(current1.data);
                current1 = current1.next;
            } else {
                d.addToTail(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            d.addToTail(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            d.addToTail(current2.data);
            current2 = current2.next;
        }

        return d;
    }
    public void addBefore(Node p, int x) {
        

        Node newNode = new Node(x);
        newNode.prev = p.prev;
        newNode.next = p;

        if (p.prev != null)
            p.prev.next = newNode;

        p.prev = newNode;
        if (p == head)
            head = newNode;

        size++;
    }

    public static void attachLists(Dou list1, Dou list2) {
        if (list1.head == null) {
            list1.head = list2.head;
            list1.tail = list2.tail;
        } else {
            list1.tail.next = list2.head;
            if (list2.head != null)
                list2.head.prev = list1.tail;
            list1.tail = list2.tail;
        }
        list1.size += list2.size;

        list2.head = null;
        list2.tail = null;
        list2.size = 0;
    }

    public int max() {
        
        int maximum = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > maximum)
                maximum = current.data;
            current = current.next;
        }
        return maximum;
    }

    public int min() {
        
        int minimum = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < minimum)
                minimum = current.data;
            current = current.next;
        }
        return minimum;
    }

    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public int avg() {
        
        int sum = sum();
        return sum / size;
    }

    public boolean sorted() {
        if (head == null || head == tail)
            return true;

        Node current = head;
        while (current.next != null) {
            if (current.data > current.next.data)
                return false;
            current = current.next;
        }
        return true;
    }
     public void insert(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (x <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (x >= tail.data) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < x)
                current = current.next;

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        size++;
    }

    public void reverse() {
        if (head == null || head == tail)
            return;

        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            current.prev = next;
            previous = current;
            current = next;
        }

        tail = head;
        head = previous;
    }

    public boolean sameContents(Dou list) {
        if (size != list.size)
            return false;

        Node current1 = head;
        Node current2 = list.head;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data)
                return false;

            current1 = current1.next;
            current2 = current2.next;
        }

        return true;
    }
}
