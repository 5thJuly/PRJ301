 


// Test function 5 to 12


public class Main1 {
    public static void main(String[] args) {
        Program g = new Program();
        g.add_First(1);
        g.add_First(2);
        g.add_First(3);
        g.add_First(4);
        g.add_First(5);  // 5 4 3 2 1
        
        
        g.traverse();
        System.out.println("=========================");
        
        //g.deleteFromHead(); 4 3 2 1
        //g.deleteFromTail(); 5 4 3 2
        
        //g.deleteAfter(g.head); // 5 3 2 1
         
        //g.delete(200);
//        Node n = g.search(200);
//        if(n != null) {
//            System.out.println("Found!!");
//        }
//        else {
//            System.out.println("Not found!!");
//        }
        
          int count = g.count();
          System.out.println("Count: " + count);
          System.out.println("=======================");
          
//          int index = 3; // i = 1;
//          g.del(index);
//          System.out.println("List after deleting node at index " + index + ":");
//          g.traverse(); //List: 5 4 2 1 
          g.sort();
          g.traverse();
    }
}
