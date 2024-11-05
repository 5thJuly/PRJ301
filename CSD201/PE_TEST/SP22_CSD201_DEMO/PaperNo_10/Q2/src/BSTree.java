/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {
   Node root;
   BSTree() {root=null;}
   boolean isEmpty() {
       return(root==null);
      }
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
     }
   void fvisit(Node p, RandomAccessFile f) throws Exception {
      if(p != null) f.writeBytes(p.info + " ");
     }
   void breadth(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void preOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }

   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xForest, int xRate, int xSound) {
    //You should insert here statements to complete this function
       if(xForest.charAt(0) == 'A') {
           return;
       }
       Boo b = new Boo(xForest, xRate, xSound);
       Node p = new Node(b);
       
       if(isEmpty()) {
           root = new Node(b);
           return;
       }
       Node f = null;
       Node q =root;
       while(q != null) {
           if(q.info.sound == xSound) {
               return;
           }
           if(xSound > q.info.sound) {
               f = q;
               q = q.right;
               
           }
           else {
               f = q;
               q  =q.left;
           }
        }
       if(f == null) {
           root = p;
       }
       else if(p.info.sound > f.info.sound) {
           f.right = p;
       }
       else {
           f.left = p;
       }
  }

//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    inOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
//=============================================================
 
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
      preOrder2(root, f);
    

    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
      if(p ==null){
          return;
      }
      if(p.info.rate < 6) {
          fvisit(p,f);
      }
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     
     }  

//=============================================================

  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    
     ArrayList<Boo> t = new ArrayList<>();
      preOrder(t, root);
      Boo b = t.get(3);
      deleByCopy(b);
      

    //------------------------------------------------------------------------------------
    preOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }
  
  void preOrder(ArrayList<Boo> t, Node p) {
        if (p == null) {
            return;
        }
        t.add(p.info);
        preOrder(t, p.left);
        preOrder(t, p.right);
    }
   public void deleByCopy(Boo x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x.rate < p.info.rate) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;  //not found
        }
        //p is leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { //p is root
                root = null;
                return;
            }
            if (p == f.left) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        //p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) { //p is root
                root = p.left;
                return;
            }
            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        //p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { //p is root
                root = p.right;
                return;
            }
            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) { //rp == q
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

//=============================================================

  void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
 

     
    //------------------------------------------------------------------------------------
    preOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
   }  

 }
