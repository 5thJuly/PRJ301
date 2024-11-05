

// Nhập vào một số nguyên dương n, tiếp theo nhập n số nguyên lần lượt là các phần tử của dãy a.
// Hãy in ra những phần tử lẻ ở chỉ số chẵn, sau mỗi phần tử có đúng một dấu cách, nếu không có phần tử nào thõa mãn thì in ra "NULL".

import java.util.Scanner;

public class Print_odd_in_even {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so pt cua mang: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        boolean kt = true;
        for (int i = 0; i < n; i++) {
            if(i%2 == 0 && a[i] % 2 == 1) {
                System.out.print(a[i] + " ");
                kt = false;
            }
        }
        if(kt) {
            System.out.println("NULL");
        }
        sc.close();
    }
}   
