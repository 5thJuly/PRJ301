// test 15
public class Main3 {
    public static void main(String[] args) {
        // test merge()
        Dou d = new Dou();
        d.addToTail(23);
        d.addToTail(24);
        d.addToTail(14);
        d.addToTail(99);
        d.traverse();
        System.out.println("=======================");
        
        
        Dou list1 = new Dou();
        list1.addToTail(5);
        list1.addToTail(15);
        list1.addToTail(25);
        list1.addToTail(35);
        list1.addToTail(45);
        
        Dou list2 = new Dou();
        list2.addToTail(1);
        list2.addToTail(7);
        list2.addToTail(12);
        list2.addToTail(32);
        list2.addToTail(47);
        list2.addToTail(59);
        
        Dou mergedList = Dou.mergeLists(list1, list2);
        System.out.print("Merged List: ");
        mergedList.traverse();
        System.out.println("=======================");
        
        d.addBefore(d.head.next, 5);
        System.out.print("After Adding: ");
        d.traverse();
        System.out.println("=======================");
        
        Dou list3 = new Dou();
        list3.addToTail(6);
        list3.addToTail(7);
        Dou.attachLists(d, list3);
        System.out.print("After attach: ");
        d.traverse();
        
    }
}
