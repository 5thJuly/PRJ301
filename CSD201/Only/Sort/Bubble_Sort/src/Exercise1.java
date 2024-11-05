
/*
 Nhập và một số nguyên dương n, tiếp theo là n số nguyên lần lượt là các phần tử của một dãy số, 
 hãy đếm tần số (số lần xuất hiện) của các số trong dãy và in nó ra màn hình dưới dạng sau: "a1 t1; a2 t2; ... an tn; ", 
 trong đó t1 là số lần xuất hiện của số a1, t2 là số lần xuất hiện của a2, ... a1, a2, .. an không trùng nhau và được sắp xếp tăng 
 dần (xem ví dụ để rõ hơn).
 */

import java.util.Scanner;

public class Exercise1 {
    public static void quickSort(int a[], int l, int r) {
        int p = a[(l+r)/2];

        int i =l;
        int j = r; 

        while(i<j) {
            while(a[i]<p) {
                i++;
            }
            while(a[j] > p) {
                j--;
            }
            if(i<= j) {
                int temp = a[i];    
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if(i < r) {
            quickSort(a, i, r);
        }
        if(l < j) {
            quickSort(a, l, j);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        quickSort(a, 0, n-1);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(a[i] == a[i-1]){
                count++;
            }
            else {
                System.out.print(a[i-1] + " " + count + "; ");
                count = 1;
            }
        }
        System.out.print(a[n-1] + " " + count + "; ");
        
    }
}