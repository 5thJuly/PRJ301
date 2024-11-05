//11 to 20


public class Main1 {
    public static void main(String[] args) {
        Dou d = new Dou();
        
        d.addtoHead(3);
        d.addtoHead(2);
        d.addtoHead(1);
        d.addToTail(13);
        d.addToTail(20);
        // 1 2 3 13 20
        
//        // delete(int i)
//        d.delete(2);
//        System.out.print("List after delete: ");
//        d.traverse(); // 1 2 13 20
//        
//        // sort()
//        d.sort();
//        System.out.print("After sorting: ");
//        d.traverse();
//        
//        // delete(Node p)
//        d.deleteAfter(d.head); // start at node 1
//        System.out.print("After delete: ");
//        d.traverse(); // 1 13 20
        
        // toArray() 
        int[] arr = d.toArray();
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("=======================");
        
        System.out.println("Max value: " + d.max());
        System.out.println("=========================");
        System.out.println("Min value: " + d.min());
        System.out.println("========================");
        System.out.println("Sum: " + d.sum());
        System.out.println("========================");
        System.out.println("Is this list sorted? " + d.sorted());
        System.out.println("========================");
        
        System.out.println("Sorted: " + d.sorted());
        d.insert(100);
        System.out.println("Sorted: " + d.sorted());
        d.traverse();
        
        System.out.print("Revered list: ");
        
        Node cur = d.head;
        while(cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
        
        Dou p1 = new Dou();
        p1.addToTail(10);
        p1.addToTail(20);
        p1.addToTail(30);
        System.out.println("List are equal: " + p1.equals(p1));

    }
    
    
}
        


