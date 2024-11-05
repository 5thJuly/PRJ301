import java.util.Scanner;

/*
Nhập và một số nguyên dương n, tiếp theo là n số nguyên của dãy số a.
Hãy in ra các số chính phương*  có trong dãy theo thứ tự tăng dần (phía sau mỗi phần tử có đúng một khoảng trắng), 
nếu không tồn tại số chính phương nào trong dãy a thì in ra "NULL".

*Số chính phương là số có thể biểu diễn được dưới dạng bình phương của một số nguyên ví dụ 0, 1, 4, 9, 16, ... là các số chính phương.

 */



public class QuickSortAndCheckPerfectSquare {
    public static void quickSort(int[] a, int l, int r) {
        int p = a[(l + r) / 2];
        int i = l, j = r;

        while (i < j) {
            while (a[i] < p) {
                i++;
            }
            while (a[j] > p) {
                j--;
            }

            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        if (i < r) {
            quickSort(a, i, r);
        }
        if (l < j) {
            quickSort(a, l, j);
        }
    }

    public static void printArray(int[] a, int n) {
        if (n == 0) {
            System.out.println("NULL");
        } else {
            System.out.print(a[0] + " ");
            for (int i = 1; i < n; i++) {
                if (a[i] != a[i - 1]) {
                    System.out.print(a[i] + " ");
                }
            }
        }
    }

    public static boolean check(int n) {
        int k = (int) Math.sqrt(n);
        return k * k == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (check(a[i])) {
                b[k] = a[i];
                k++;
            }
        }

        quickSort(b, 0, k - 1);
        printArray(b, k);

        scanner.close();
    }
}
