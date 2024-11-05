//1->10
public class Main {
    public static void main(String[] args) {
        Dou d = new Dou();
        
        d.addtoHead(3);
        d.addtoHead(2);
        d.addtoHead(1);
        System.out.print("List: ");
        d.traverse();
        // 1 2 3
        
        d.addToTail(13);
        d.addToTail(20);
        System.out.print("List: ");
        d.traverse();
        // 1 2 3 13 20
        
        // Add_After 
        d.addAfter(d.head.next.next, 4);
        System.out.print("List after adding : ");
        //  1 2 3 4 13 20 

        d.traverse();
        
        // deleteHead 
        int deletedValue = d.deleteFromHead();
        System.out.println("Deleted value: " + deletedValue);
        System.out.print("Lsit after delete: ");
        d.traverse();
        
        deletedValue = d.deleteFromTail();
        System.out.println("Deleted value: " + deletedValue); // Output: Deleted value: 5
        // List: 2 -> 3 -> 6 -> 4
        System.out.print("Lsit after delete: ");
        d.traverse(); // Output: 2 3 4 13 
        
        //deleteAfter
        d.deleteAfter(d.head.next.next);
        System.out.print("Lsit after delete: ");
        d.traverse(); // 2 3 4
        
        // delete 
        d.deleted(2);
        System.out.print("Lsit after delete: ");
        d.traverse(); // 3 4
        
        
        int count = d.count();
        System.out.println("Count: " + count);
        System.out.println("=======================");

    }
}
