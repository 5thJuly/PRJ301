import java.util.Scanner;

public class Selection_sort {
    public static void printArray(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void selection_Sort(int a[], int n) {
        int in_Min;

        for (int i = 0; i < n-1; i++) {
            in_Min = i;
            for (int j = i+1; j < n; j++) {
                if(a[in_Min] > a[j]) {
                    in_Min = j;
                }
            }
            if(i != in_Min) {
                int temp = a[i];
                a[i] = a[in_Min];
                a[in_Min] = temp;
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
        selection_Sort(a, n);
        printArray(a, n);
        sc.close();
    }
    
}
