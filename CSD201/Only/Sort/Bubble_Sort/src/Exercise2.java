/*
 Trong diễn biến dịch Covid-19 đang diễn ra khá phức tạp, việc tuyền truyền cách phòng tránh dịch là rất quan trong, 
 gọi a[i] là tọa độ của người thứ i, khoảng cách giữa hai người i và j là |a[i]-a[j]|. Một người có thể truyền được thông tin đến 
 người khác nếu khoảng cách giữa họ không vượt quá k.

Để tuyền truyền thông tin nhanh chóng thì người ta sẽ chỉ truyền thông tin cho 1 số người ban đầu, 
sau đó họ sẽ truyền thông tin cho người khác, Hãy đưa ra số lượng ít nhất là số người ban đầu cần truyền thông tin, 
để sao cho tất cả mọi người đều tiếp cận được thông tin.
 */





import java.util.Scanner;

public class Exercise2 {
    
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
    public static int result(int a[], int n, int k) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if(a[i] - a[i-1] > k){
                count++;
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        quickSort(a, 0, n-1);
        System.out.println(result(a, n, k));

    }
}
