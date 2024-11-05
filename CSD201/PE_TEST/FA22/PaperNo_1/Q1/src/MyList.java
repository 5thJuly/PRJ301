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
    void addLast(String xBrand, int xColor, int xWeight) {
        //You should write here appropriate statements to complete this function.
        Bike b = new Bike(xBrand, xColor, xWeight);
        if (xBrand.charAt(0) == 'A') {
            return;
        }
        if (isEmpty()) {
            head = tail = new Node(b);
        } else {
            Node n = new Node(b);
            tail.next = n;
            tail = n;

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
        Bike x, y;
        x = new Bike("X", 1, 2);
        y = new Bike("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node nX = new Node(x);
        Node nY = new Node(y);

        addpos(2, nY);
        int n = size();
        addpos(n - 1, nX);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void addpos(int pos, Node x) {
        Node p = head;
        while (pos-- > 1) {
            p = p.next;

        }
        Node n = new Node(x.info, p.next);
        p.next = n;

    }

    int size() {
        int count = 0;
        Node n = head;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
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
        int count = 0, pos = 0;

        while (p != null) {
            if (p.info.weight < 6) {
                count++;
            }
            if (count == 2) {
                delePos(pos);
            } else {
                p = p.next;
                pos++;
            }
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void delePos(int pos) {
        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        p.next = p.next.next;
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

        //find minWeight
        Node p = head;
        Node minWeight = head;
        while (p != null) {
            // neu de bai yeu cau tim first min -> <
            // --------------tim last min -> <=
            //------------- first max -> >
            // ------------last max -> >=
            if (p.info.weight < minWeight.info.weight) {
                minWeight = p;
            }
            p = p.next;
        }
        // dem tu min den k xem co bn pt

        int count = 0;
        p = head;
        while (minWeight != null) {

            count++;
            minWeight = minWeight.next;

        }
        
        
        sortElement(count);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void sortElement(int k) {
        int count = size() - k;
        Node p = head, q;
        while (count-- > 0) {
            p = p.next;
        }
        while (p != null) {
            q = p.next;
            while (q != null) {
                if (p.info.weight > q.info.weight) {
                    // Swap 2 bike
                    Bike temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
                q = q.next;
            }
            p = p.next;
        }
    }
}
