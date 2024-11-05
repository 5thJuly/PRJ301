import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements of m: ");
        int m = sc.nextInt();
        System.out.print("Number of elements of n: ");
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        
        // Nhập ma trận a
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        
        // Tính tổng các phần tử của ma trận a
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += a[i][j];
            }
        }
        
        // In ra tổng
        System.out.println(sum);
        sc.close();
    }
}




