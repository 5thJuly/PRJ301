import java.util.Scanner;

public class Find_Min_closet {

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
    public static int solve(int a[], int n) {
        quickSort(a, 0, n - 1);
        if(a[0] > 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if(a[i] - a[i-1] > 1) {
                return a[i-1] +1;
            }
        }
        return a[n-1] + 1;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k =0;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(solve(a, n));

        sc.close();
    }
}
