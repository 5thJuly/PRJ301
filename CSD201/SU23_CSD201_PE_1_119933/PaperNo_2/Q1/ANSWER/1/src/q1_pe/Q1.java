/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1_pe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "BFS_input.txt";
    String outputFile = "BFS_output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    
    int n, v;
    ArrayList<Integer> a;
    BSTree tree;
    String res;


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    String fi, fo;
    
    /**
     * Set input and output file for automatic rating
     * @param args path of input file and path of output file
     */
    public void setFile (String[] args){
        fi = args.length>=2? args[0]: inputFile;
        fo = args.length>=2? args[1]: outputFile;
    }
    
    /**
     * Reads data from input file
     */
    public void read(){
        try {
            Scanner sc = new Scanner(new File(fi));
            a = new ArrayList<>();
            n = sc.nextInt();
            int value;
            for (int i = 0; i < n; i++) {
                value = sc.nextInt();
                a.add(value);
            }
            v = sc.nextInt();
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    //--END FIXED PART----------------------------
    
    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    

    
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve(){
    //--END FIXED PART----------------------------
        
        //ALGORITHM - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
        tree = new BSTree();
        for (int i = 0; i < n; i++) {
            tree.addNode(a.get(i));
        }
        if (tree.root == null) 
            return;
        MyQueue q = new MyQueue();
        q.enqueue(tree.root);
        BSTNode p;
        while (!q.isEmpty()) {
            p = q.dequeue();
            if (p.getData() >= v)
                res += p.getData() + ",";
            if (p.hasLeftChild())
                q.enqueue(p.getLeftChild());
            if (p.hasRightChild())
                q.enqueue(p.getRightChild());
        }
        res = res.substring(4, res.length() - 1);
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
    }
    
    /**
     * Write result into output file
     */
    public void printResult(){
	try {
            FileWriter fw = new FileWriter(fo);
            fw.write(res + "\n");
            fw.flush();
            fw.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

   
    public static void main(String[] args) {
        // TODO code application logic here
        Q1 q = new Q1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	    
}
