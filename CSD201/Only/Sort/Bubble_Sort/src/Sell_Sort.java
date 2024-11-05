import java.util.Scanner;

public class Sell_Sort {
    public static void printArray(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void sellSort(int a[], int n) {
        int interval, i, j, temp;

        for(interval = n/2; interval > 0; interval /= 2) {
            for(i = interval; i<n; i++) {
                temp = a[i];
                for(j=i; j >= interval && a[j-interval] > temp; j -= interval) {
                    a[j] = a[j-interval];
                }
                a[j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];   

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sellSort(a, n);
        printArray(a, n);

        sc.close();
    }
}
