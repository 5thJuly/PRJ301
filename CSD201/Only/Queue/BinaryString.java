import java.util.*;

public class BinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input s: ");
        int s = sc.nextInt();
        Stack<Character> t = new Stack<>();
        while(s>0) {
            t.push((char) (s%2 + '0'));
            s = s/2;

        }
        while(!t.isEmpty()) {
            System.out.print(t.pop());
        }
        sc.close();
        
    }   
}
