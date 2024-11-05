/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xSea, int xSail, int xPaddle) {
        //You should write here appropriate statements to complete this function.
        if (xSea.charAt(0) == 'A') {
            return;
        }
        Boat b = new Boat(xSea, xSail, xPaddle);
        Node p = new Node(b);
        if (isEmpty()) {
            head = tail = p;

        } else {
            tail.next = p;
            tail = p;
        }

    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Boat x, y, z;
        x = new Boat("X", 1, 2);
        y = new Boat("Y", 2, 3);
        z = new Boat("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node nX = new Node(x);
        Node nY = new Node(y);
        Node nZ = new Node(z);

        addPosition(1, nX);
        addPosition(3, nY);
        addPosition(4, nZ);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void addPosition(int pos, Node x) {
        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        Node n = new Node(x.info, p.next);
        p.next = n;
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = head;
        Node q = head;
        int count = 0;
        int max = p.info.paddle;
        
        while(p!=null) {
            if(max < p.info.paddle) {
                max = p.info.paddle;
            }
            p = p.next;
        }
        while(q != null) {
            if(max == q.info.paddle) {
                count++;
            }
            if(count==2) {
                addLast(q.info.sea, q.info.sail, q.info.paddle);
                delete_N(q);
                break;
            }
            q = q.next;
        }
        
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    public void delete_N(Node p) {
        if(head == null) {
            head = head.next;
            return;
        }
        Node cur = head;
        while(cur != null && cur.next != p) {
            cur = cur.next;
        }
        if(cur != null) {
            cur.next = cur.next.next;
        }
    }
   
//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sortByASC(3, 7);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    ArrayList<Node> getElementsFromBeginToEnd(int begin, int end) {
        Node node = head;
        int size = end - begin + 1;
        ArrayList<Node> list = new ArrayList<>();
        int index = 1;

        while (node != null) {
            if (index > end) {
                return list;
            } else if (index >= begin) {
                list.add(node);
            }

            node = node.next;
            ++index;
        }

        return list;
    }

    void sortByASC(int begin, int end) {

        ArrayList<Node> list = getElementsFromBeginToEnd(begin, end);

        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) //chinh sua so sanh o day
            {
                if (list.get(i).info.paddle > list.get(j).info.paddle) {
                    Boat tmp = list.get(i).info;
                    list.get(i).info = list.get(j).info;
                    list.get(j).info = tmp;
                }
            }
        }
    }

}
