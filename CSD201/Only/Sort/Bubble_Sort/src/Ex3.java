import java.util.Scanner;


/*
Hải có một dãy số gồm n số nguyên, Hải muốn sắp xếp các phần tử của dãy đó với các yêu cầu sau:

Từ trái qua phải:
Các số nguyên dương xuất hiện theo giá trị tăng dần.
Các số nguyên âm xuất hiện theo giá trị giảm dần.
Không thay đổi vị trí của phần tử mang giá trị 0.
Không thay đổi tính chất ở mỗi vị trí (Nghĩa là nếu trước khi sắp xếp vị trí i có giá trị nguyên âm thì sau khi sắp xếp 
vị trị i cũng phải mang giá trị âm, nếu ví trị i mang giá trị dương cũng tương tự).
Cho trước dãy a. Hãy sắp xếp theo cách của Hải. In kết quả ra màn hình, sau mỗi phần tử có đúng một khoảng trắng.
 */




public class Ex3 {
    public static void quickSort(int a[], int l, int r) {
        int p = a[(l+r)/2];
        int i = l;
        int j = r;
        while(i < j) {
            while(a[i] < p) {
                i++;
            }
            while(a[j] > p) {
                j--;
            }
            if(i <=j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if(i<r) {
            quickSort(a, i, r);
        }
        if(l < j) {
            quickSort(a, l, j);
        }
    }
    public static void printArray(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] != 0) {
                b[k] = a[i];
                k = k+1;
            }
        }
        quickSort(b, 0, k-1);
        k=0;
        for (int i = n-1; i >=0; i--) {
            if(a[i] < 0) {
                a[i] = b[k];
                k = k+1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(a[i] > 0) {
                a[i] = b[k];
                k = k+1;
            }
        }
        printArray(a, n);
    }
}
