import java.util.Scanner;

public class Merge_Sort {
    public static void Merg(int a[], int l, int m, int r){
        int i,j,k;
        int n1 = m-l+1;
        int n2 = r-m;

        int L[] = new int[n1]; 
        int R[] = new int [n2];
        for(i=0;i<n1;i++){
            L[i] = a[l+i];
        
        }
        for(j=0;j<n2;j++){
            R[j] = a[m+j+1];
        }
        i=0;
        j=0;
        k=l;

        while(i <n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
    }
    public static void Merge_Sort(int a[], int l, int r){
        if(l < r){
            int m = (l+r)/2;
            Merge_Sort(a, l, m);
            Merge_Sort(a, m+1, r);
            Merg(a, l, m, r);
            }
        }
    
    public static void printArray(int a[], int n) {
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Nhap so pt cua mang: ");
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("PT thu " + i+ ": ");
            a[i] = sc.nextInt();
        }
        Merge_Sort(a, 0, n-1);
        System.out.println("=======================");
        System.out.print("Mang sau khi sap xep: ");
        printArray(a, n);

        sc.close();
    }

}
