


// Test function 1 to 4




public class Main {
    public static void main(String[] args) {
        Program g = new Program();
        
        g.add_First(1);
        g.add_First(2);
        g.add_First(3);
        g.add_First(4);
        g.add_First(5);
        g.traverse();
        g.add_Last(10);
        g.traverse();
        g.add_After(g.head, 20); // sau head 1 node
        g.traverse();
    }
}
