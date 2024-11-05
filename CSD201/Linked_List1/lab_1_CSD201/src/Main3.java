

// Test 22 - 25

public class Main3 {
    public static void main(String[] args) {
        Program g = new Program();
        g.add_Last(20);
        g.add_Last(50);
        g.add_Last(30);
        
        
        System.out.println("Sorted: " + g.sorted());
        g.insert(100);
        System.out.println("Sorted: " + g.sorted());
        g.traverse();
        
        System.out.println("Revered list: ");
        Node cur = g.head;
        while(cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
        
        Program p1 = new Program();
        p1.add_Last(10);
        p1.add_Last(20);
        p1.add_Last(30);
        System.out.println("List are equal: " + p1.equals(p1));
        
        
        
        
    }
}
