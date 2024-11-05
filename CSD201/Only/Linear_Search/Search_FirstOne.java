import java.util.Scanner;

public class Search_FirstOne {
    public static int search(int[] a, int n, int x) {
        for (int i = 0; i < n; i++) {
            if(a[i] == x) {
                return i;
            }
            
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap so pt cua mang: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + i + ": ");
            a[i] = sc.nextInt();
            
        }
        System.out.print("Nhap phan tu tim kiem: ");
        int x = sc.nextInt();

        System.out.println(search(a, n, x));

        sc.close();
    }
}