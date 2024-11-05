import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;

        System.out.print("a = ");
        a = sc.nextInt();

        if(a % 2 == 0) {
            System.out.println(a + " la so chan");
        }
        else if(a % 2 == 1) {
            System.out.println(a + " la so le");
        }
    }
}