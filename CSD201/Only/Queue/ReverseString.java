import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input String: ");
        String s = sc.nextLine();
        Stack<Character> t = new Stack<>();  
        for (int i = 0; i < s.length(); i++) {
            t.push(s.charAt(i)) ;
            
        }
        while(!t.isEmpty()){
            System.out.print(t.pop());

        }
        sc.close();
    }
}
