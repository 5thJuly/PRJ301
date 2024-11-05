class Linked_List {
    Node head;
    private Node tail;
    private int size;

    Linked_List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void addToHead(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addToTail(String data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void addAfter(Node p, String data) {
        if (p == null) {
            System.out.println("Invalid node.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;
        if (p == tail) {
            tail = newNode;
        }
        size++;
    }

    void traverse() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    String deleteFromHead() {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }

        String deletedData = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return deletedData;
    }

    String deleteFromTail() {
        if (tail == null) {
            System.out.println("List is empty.");
            return null;
        }

        String deletedData = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node currentNode = head;
            while (currentNode.next != tail) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            tail = currentNode;
        }
        size--;
        return deletedData;
    }

    String deleteAfter(Node p) {
        if (p == null || p.next == null) {
            System.out.println("Invalid node.");
            return null;
        }

        Node deletedNode = p.next;
        p.next = deletedNode.next;
        if (deletedNode == tail) {
            tail = p;
        }
        size--;
        return deletedNode.data;
    }

    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null && !currentNode.next.data.equals(data)) {
            currentNode = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
            if (currentNode.next == null) {
                tail = currentNode;
            }
            size--;
        } else {
            System.out.println("Node not found.");
        }
    }

    Node search(String data) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    int count() {
        return size;
    }
}