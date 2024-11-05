import java.util.Scanner;
import java.util.Stack;

public class EncodeString{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input String: ");
    String s = sc.nextLine();
    s = s + '@';
    Stack<Character> st = new Stack<>();
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (st.empty() || st.peek() == s.charAt(i)) {
        st.push(s.charAt(i));
      } 
      else {
        int count = 0;
        str.append(st.peek());
        while (!st.empty()) {
          count++;
          st.pop();
        }
        str.append(count);
        st.push(s.charAt(i));
      }
    }
    System.out.println(str);
    sc.close();
  }
}