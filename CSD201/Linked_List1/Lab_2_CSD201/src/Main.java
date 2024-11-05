
public class Main {
    public static void main(String[] args) {
        Linked_List l = new Linked_List();
        l.addToHead("Node 1");
        l.addToTail("Node 2");
        l.addAfter(l.head, "Node 3");
        l.traverse(); // Node 1 Node 3 Node 2

        System.out.println("Deleted from head: " + l.deleteFromHead()); //  Deleted from head: Node 1
        System.out.println("Deleted from tail: " + l.deleteFromTail()); //  Deleted from tail: Node 2

        Node searchResult = l.search("Node 3");
        if (searchResult != null) {
            System.out.println("Node found: " + searchResult.data); //  Node found: Node 3
        } else {
            System.out.println("Node not found.");
        }

        System.out.println("Node count: " + l.count()); //  Node count: 1
    }
}