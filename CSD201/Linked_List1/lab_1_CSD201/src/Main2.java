
// test 14 to 21


public class Main2 {
    public static void main(String[] args) {
        Program list = new Program();
        
        list.add_Last(10);
        list.add_Last(20);
        list.add_Last(30);
        list.add_Last(40);
        list.add_Last(50);
        list.add_Last(60);
        list.traverse();
        
        System.out.println("======================");
        
        // test toArray()
        int[] arr = list.toArray();
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("=======================");
        
        // test merge()
        Program list1 = new Program();
        list1.add_Last(5);
        list1.add_Last(15);
        list1.add_Last(25);
        list1.add_Last(35);
        list1.add_Last(45);
        
        Program list2 = new Program();
        list2.add_Last(1);
        list2.add_Last(7);
        list2.add_Last(12);
        list2.add_Last(32);
        list2.add_Last(47);
        list2.add_Last(59);
        
        Program mergedList = Program.merge(list1, list2);
        System.out.print("Merged List: ");
        mergedList.traverse();
        System.out.println("=======================");
        
        // test addBefore()
        Node p = list.head.next;
        list.addBefore(p, 25);
        System.out.print("List after adding 25 before second Node: ");
        list.traverse();
        System.out.println("=======================");
        // test attach()
        Program list3 = new Program();
        list3.add_Last(70);
        list3.add_Last(80);
        list3.add_Last(90);
        
        list.attach(list3);
        System.out.print("List after attaching another list: ");
        list.traverse();
        System.out.println("=======================");
        // test max()
        System.out.println("Maximum value in the list: " + list.max());
        System.out.println("=======================");
        // test min()
        System.out.println("Minimum value in the list: " + list.min());
        System.out.println("=======================");
        // test sum()
        System.out.println("Sum of all values in the list: " + list.sum());
        System.out.println("=======================");
        // test avg()
        System.out.println("Average of all values in the list: " + list.avg());
        System.out.println("=======================");
        // test sorted()
        System.out.println("Is the list sorted? " + list.sorted());
        System.out.println("=======================");
        // test insert()
        list.insert(55);
        System.out.print("List after inserting 55: ");
        list.traverse();
        System.out.println("=======================");
        // test reverse()
        list.reverse();
        System.out.print("Reversed list: ");
        list.traverse();
        System.out.println("=======================");
        // test equals()
        Program list4 = new Program();
        list4.add_Last(10);
        list4.add_Last(20);
        list4.add_Last(30);
        list4.add_Last(40);
        list4.add_Last(50);
        list4.add_Last(60);
        
        System.out.println("Are list and list4 equal? " + list.equals(list4));
    }

}

