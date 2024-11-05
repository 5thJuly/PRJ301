import java.util.Scanner;

public class Quick_Sort {
    
    public static void printArray(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void quickSort(int a[], int l, int r) {
        if (l < r) {
            int p = a[(l + r) / 2];
            int i = l;
            int j = r;
            
            while (i <= j) {
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
            
            quickSort(a, l, j);
            quickSort(a, i, r);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        quickSort(a, 0, n - 1);
        printArray(a, n);

        sc.close();
    }
}
