import java.util.*;

public class MergeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Nhập số lượng phần tử của hai dãy a và b
        System.out.print("Nhap so pt cua n: ");
        int n = sc.nextInt();
        System.out.print("Nhap so pt cua m: ");
        int m = sc.nextInt();

        // Khai báo hai mảng a và b
        int[] a = new int[n];
        int[] b = new int[m];

        // Nhập dãy a
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu a[" + i + "]: ");
            a[i] = sc.nextInt();
        }

        // Nhập dãy b
        for (int i = 0; i < m; i++) {
            System.out.println();
            System.out.print("Nhap phan tu b[" + i + "]: ");
            b[i] = sc.nextInt();
        }

        // Khai báo mảng c
        int[] c = new int[n + m];

        // Gộp hai dãy a và b vào mảng c
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
                k++;

            } 
            else {
                c[k] = b[j];
                k++;
                j++;
            }
            
        }

        // Nếu còn phần tử trong dãy a thì thêm vào mảng c
        while (i < n) {
            c[k] = a[i];
            i++;
            k++;
        }

        // Nếu còn phần tử trong dãy b thì thêm vào mảng c
        while (j < m) {
            c[k] = b[j];
            j++;
            k++;
        }

        // Xuất dãy c
        for (int l = 0; l < k; l++) {
            System.out.print(c[l] + " ");
        }

        sc.close();
    }
}
